package com.tropicgame.tinkoffnewstest.mvp.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.tropicgame.tinkoffnewstest.R;
import com.tropicgame.tinkoffnewstest.common.Const;
import com.tropicgame.tinkoffnewstest.common.presenter.BasePresenter;
import com.tropicgame.tinkoffnewstest.mvp.presenters.contract.DetailNewsActivityPresenter;
import com.tropicgame.tinkoffnewstest.mvp.views.activities.contract.DetailNewsActivityView;
import com.tropicgame.tinkoffnewstest.network.request.RequestParams;
import com.tropicgame.tinkoffnewstest.network.response.NewsDetailsResponse;
import com.tropicgame.tinkoffnewstest.network.tasks.NewsLoadIDetailTask;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

/**
 * Created by xpusher on 4/6/2018.
 */

public class DetailNewsActivityPresenterImpl extends BasePresenter<DetailNewsActivityView> implements DetailNewsActivityPresenter<DetailNewsActivityView> {

    private String id;

    private NewsLoadIDetailTask newsLoadIDetailTask;
    private Context context;

    @Inject
    public DetailNewsActivityPresenterImpl(NewsLoadIDetailTask newsLoadIDetailTask,Context context){
        this.newsLoadIDetailTask = newsLoadIDetailTask;
        this.context = context;

    }

    @Override
    public void onAttach(DetailNewsActivityView var1) {
        view=var1;
    }

    @Override
    public void parseIntent(Intent intent) {
        id=intent.getData().toString();
    }

    @Override
    public void request(RequestParams requestParams) {
        if (id == null)
            view.finish();
        else{
            view.showSwipeRefresh(true);
            requestParams.put(Const.KEY_ID,id);
            newsLoadIDetailTask.execute(requestParams, new Subscriber<NewsDetailsResponse>() {
                @Override
                public void onSubscribe(Subscription s) {

                }

                @Override
                public void onNext(NewsDetailsResponse newsDetailsResponse) {
                    view.showSwipeRefresh(false);
                    view.showResponseNewsDetails(newsDetailsResponse);
                }

                @Override
                public void onError(Throwable t) {
                    view.showSwipeRefresh(false);
                    Toast.makeText(context, context.getString(R.string.error,t.getMessage()),Toast.LENGTH_SHORT).show();
                    view.showResponseNewsDetails(new NewsDetailsResponse(context.getString(R.string.text_need_connect_internet)));
                }

                @Override
                public void onComplete() {

                }
            });
        }


    }
}
