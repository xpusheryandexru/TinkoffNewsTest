package com.tropicgame.tinkoffnewstest.mvp.views.activities.contract;

import com.tropicgame.tinkoffnewstest.common.contract.BasicActivityView;
import com.tropicgame.tinkoffnewstest.network.response.NewsDetailsResponse;
import com.tropicgame.tinkoffnewstest.network.response.NewsItemsResponse;

/**
 * Created by xpusher on 4/6/2018.
 */

public interface DetailNewsActivityView extends BasicActivityView {
    void finish();
    void showResponseNewsDetails(NewsDetailsResponse newsDetailsResponse);

    void showSwipeRefresh(boolean show);

}
