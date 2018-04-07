package com.tropicgame.tinkoffnewstest.mvp.presenters.contract;

import com.tropicgame.tinkoffnewstest.network.request.RequestParams;

public interface MainActivityPresenter<T> {

    void onAttach(T var1);

    void requestPayloadItems(RequestParams requestParams);
}
