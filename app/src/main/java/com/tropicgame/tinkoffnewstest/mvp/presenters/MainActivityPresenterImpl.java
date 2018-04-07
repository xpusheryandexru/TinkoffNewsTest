package com.tropicgame.tinkoffnewstest.mvp.presenters;

import android.content.Context;
import android.widget.Toast;

import com.tropicgame.tinkoffnewstest.R;
import com.tropicgame.tinkoffnewstest.common.presenter.BasePresenter;
import com.tropicgame.tinkoffnewstest.mvp.presenters.contract.MainActivityPresenter;
import com.tropicgame.tinkoffnewstest.mvp.views.activities.contract.MainActivityView;
import com.tropicgame.tinkoffnewstest.network.request.RequestParams;
import com.tropicgame.tinkoffnewstest.network.response.NewsItemsResponse;
import com.tropicgame.tinkoffnewstest.network.tasks.NewsLoadItemsTask;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

public class MainActivityPresenterImpl extends BasePresenter<MainActivityView> implements MainActivityPresenter<MainActivityView> {

    private NewsLoadItemsTask newsLoadItemsTask;
    private Context context;

    @Inject
    public MainActivityPresenterImpl(NewsLoadItemsTask newsLoadItemsTask, Context context){
        this.newsLoadItemsTask = newsLoadItemsTask;
        this.context = context;
    }


    @Override
    public void onAttach(MainActivityView mainActivityView) {
        view= mainActivityView;
    }

    @Override
    public void requestPayloadItems(RequestParams requestParams) {
        view.showSwipeRefresh(true);
        newsLoadItemsTask.cancel();
        newsLoadItemsTask.execute(requestParams, new Subscriber<NewsItemsResponse>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(NewsItemsResponse newsItemsResponse) {
                view.showSwipeRefresh(false);
                view.showResponseNewsItems(newsItemsResponse);

            }

            @Override
            public void onError(Throwable t) {
                view.showSwipeRefresh(false);
                Toast.makeText(context, context.getString(R.string.error,t.getMessage()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
