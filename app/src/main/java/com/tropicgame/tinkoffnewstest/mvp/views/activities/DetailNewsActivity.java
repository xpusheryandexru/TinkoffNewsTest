package com.tropicgame.tinkoffnewstest.mvp.views.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import com.tropicgame.tinkoffnewstest.R;
import com.tropicgame.tinkoffnewstest.common.Const;
import com.tropicgame.tinkoffnewstest.common.view.BaseActivity;
import com.tropicgame.tinkoffnewstest.dagger.components.PresentersComponent;
import com.tropicgame.tinkoffnewstest.mvp.presenters.contract.DetailNewsActivityPresenter;
import com.tropicgame.tinkoffnewstest.mvp.views.activities.contract.DetailNewsActivityView;
import com.tropicgame.tinkoffnewstest.network.request.RequestParams;
import com.tropicgame.tinkoffnewstest.network.response.NewsDetailsResponse;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailNewsActivity extends BaseActivity implements DetailNewsActivityView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.activity_details_news_swipe_refresh)
    SwipeRefreshLayout details_news_swipe_refresh;
    @BindView(R.id.activity_details_news_text)
    TextView news_text;

    @Inject
    DetailNewsActivityPresenter presenter;

    private RequestParams requestParams=new RequestParams();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_payload);
    }

    @Override
    protected void init() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        details_news_swipe_refresh.setOnRefreshListener(this);
        setTitle(R.string.title_details_news_activity);
    }

    @Override
    protected void attachPresenter(PresentersComponent presentersComponent) {
        presentersComponent.inject(this);
        presenter.onAttach(this);
        presenter.parseIntent(getIntent());
        requestParams.clear();
        requestParams.put(Const.KEY_CACHE_CONTROL,Const.FROM_CACHE);
        presenter.request(requestParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showResponseNewsDetails(NewsDetailsResponse newsDetailsResponse) {
        news_text.setText(Html.fromHtml(
                newsDetailsResponse.getPayload().getContent()
        ));
        news_text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void showSwipeRefresh(boolean show) {
        details_news_swipe_refresh.setRefreshing(show);
    }

    @Override
    public void onRefresh() {
        requestParams.clear();
        requestParams.put(Const.KEY_CACHE_CONTROL,Const.FROM_SERVER);
        presenter.request(requestParams);

    }
}
