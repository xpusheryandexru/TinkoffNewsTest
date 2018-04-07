package com.tropicgame.tinkoffnewstest.mvp.views.activities;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.tropicgame.tinkoffnewstest.R;
import com.tropicgame.tinkoffnewstest.common.Const;
import com.tropicgame.tinkoffnewstest.common.contract.InteractiveModelView;
import com.tropicgame.tinkoffnewstest.common.view.BaseActivity;
import com.tropicgame.tinkoffnewstest.common.view.BaseFlexibleAdapter;
import com.tropicgame.tinkoffnewstest.dagger.components.PresentersComponent;
import com.tropicgame.tinkoffnewstest.modeles.NewsItem;
import com.tropicgame.tinkoffnewstest.mvp.presenters.contract.MainActivityPresenter;
import com.tropicgame.tinkoffnewstest.mvp.views.activities.contract.MainActivityView;
import com.tropicgame.tinkoffnewstest.mvp.views.items.NewsItemIFlexible;
import com.tropicgame.tinkoffnewstest.mvp.views.widget.RecyclerViewEmptySupport;
import com.tropicgame.tinkoffnewstest.network.request.RequestParams;
import com.tropicgame.tinkoffnewstest.network.response.NewsItemsResponse;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import butterknife.BindView;
import eu.davidea.flexibleadapter.items.IFlexible;

public class MainActivity extends BaseActivity implements MainActivityView, SwipeRefreshLayout.OnRefreshListener,InteractiveModelView.Listener{

    //region BindView
    @BindView(R.id.activity_main_recycler_news)
    RecyclerViewEmptySupport recycler_news;
    @BindView(R.id.activity_main_swipe_refresh)
    SwipeRefreshLayout swipe_refresh;
    @BindView(R.id.activity_main_text_recycler_empty)
    TextView text_recycler_empty;
    //endregion

    //region Inject
    @Inject
    MainActivityPresenter mainActivityPresenter;
    //endregion

    //region Private
    private ArrayList<IFlexible>  payloadItemArrayList=new ArrayList<>();
    private BaseFlexibleAdapter adapter;
    private RequestParams requestParams=new RequestParams();
    //endregion

    //region MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void init() {
        ActionBar actionBar=getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        adapter=new BaseFlexibleAdapter(payloadItemArrayList,this);
        recycler_news.setLayoutManager(new LinearLayoutManager(this));
        recycler_news.setEmptyView(text_recycler_empty);
        recycler_news.setAdapter(adapter);

        swipe_refresh.setOnRefreshListener(this);
    }

    @Override
    protected void attachPresenter(PresentersComponent presentersComponent) {
        presentersComponent.inject(this);
        mainActivityPresenter.onAttach(this);
        requestParams.clear();
        requestParams.put(Const.KEY_CACHE_CONTROL,Const.FROM_CACHE);
        mainActivityPresenter.requestPayloadItems(requestParams);
    }
    //endregion

    //region MainActivityView
    @Override
    public void showResponseNewsItems(NewsItemsResponse newsItemsResponse) {

        payloadItemArrayList.clear();

        //region ResponceToItems
        newsItemsResponse.sortNewsByPublicationDateDes();
        Iterator<NewsItem> iterator= newsItemsResponse.getNewsItem().iterator();
        while (iterator.hasNext())
            payloadItemArrayList.add(new NewsItemIFlexible(iterator.next()));
        //endregion

        adapter.notifyDataSetChanged();


    }

    @Override
    public void showSwipeRefresh(boolean show) {
        swipe_refresh.setRefreshing(show);
    }

    //endregion

    //region User Events
    @Override
    public void onRefresh() {
        requestParams.clear();
        requestParams.put(Const.KEY_CACHE_CONTROL,Const.FROM_SERVER);
        mainActivityPresenter.requestPayloadItems(requestParams);
        swipe_refresh.setEnabled(true);
    }


    @Override
    public void onModelAction(int var1, Object var2) {
        startActivity(new Intent(null, Uri.parse(((NewsItem)var2).getId()),this,DetailNewsActivity.class));
    }
    //endregion

}
