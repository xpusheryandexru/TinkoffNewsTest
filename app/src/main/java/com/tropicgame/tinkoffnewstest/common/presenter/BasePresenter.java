package com.tropicgame.tinkoffnewstest.common.presenter;

import com.tropicgame.tinkoffnewstest.common.contract.BasicActivityView;

public class BasePresenter<V extends BasicActivityView> {
    protected V view;
}
