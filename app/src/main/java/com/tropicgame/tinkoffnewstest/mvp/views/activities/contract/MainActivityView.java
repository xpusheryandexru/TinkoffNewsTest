package com.tropicgame.tinkoffnewstest.mvp.views.activities.contract;

import com.tropicgame.tinkoffnewstest.common.contract.BasicActivityView;
import com.tropicgame.tinkoffnewstest.network.response.NewsItemsResponse;

public interface MainActivityView extends BasicActivityView {
    void showResponseNewsItems(NewsItemsResponse newsItemsResponse);

    void showSwipeRefresh(boolean show);
}
