package com.tropicgame.tinkoffnewstest.mvp.presenters.contract;

import android.content.Intent;

import com.tropicgame.tinkoffnewstest.network.request.RequestParams;

/**
 * Created by xpusher on 4/6/2018.
 */

public interface DetailNewsActivityPresenter<T> {
    void onAttach(T var1);

    void parseIntent(Intent intent);

    void request(RequestParams requestParams);
}
