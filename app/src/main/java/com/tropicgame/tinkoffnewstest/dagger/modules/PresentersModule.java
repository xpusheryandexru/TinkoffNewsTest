package com.tropicgame.tinkoffnewstest.dagger.modules;

import com.tropicgame.tinkoffnewstest.dagger.scopes.PresentersScope;
import com.tropicgame.tinkoffnewstest.mvp.presenters.DetailNewsActivityPresenterImpl;
import com.tropicgame.tinkoffnewstest.mvp.presenters.contract.DetailNewsActivityPresenter;
import com.tropicgame.tinkoffnewstest.mvp.presenters.contract.MainActivityPresenter;
import com.tropicgame.tinkoffnewstest.mvp.presenters.MainActivityPresenterImpl;
import com.tropicgame.tinkoffnewstest.common.view.BaseActivity;


import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {
    public PresentersModule(BaseActivity baseActivity) {

    }

    @Provides
    @PresentersScope
    MainActivityPresenter provideStartPresenter(MainActivityPresenterImpl presenter) {
        return presenter;
    }


    @Provides
    @PresentersScope
    DetailNewsActivityPresenter provideDetailPayloadActivityPresenter(DetailNewsActivityPresenterImpl presenter) {
        return presenter;
    }
}
