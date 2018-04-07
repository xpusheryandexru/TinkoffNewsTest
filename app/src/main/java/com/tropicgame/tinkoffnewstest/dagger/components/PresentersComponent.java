package com.tropicgame.tinkoffnewstest.dagger.components;

import com.tropicgame.tinkoffnewstest.dagger.modules.PresentersModule;
import com.tropicgame.tinkoffnewstest.dagger.scopes.PresentersScope;
import com.tropicgame.tinkoffnewstest.mvp.views.activities.DetailNewsActivity;
import com.tropicgame.tinkoffnewstest.mvp.views.activities.MainActivity;

import dagger.Subcomponent;

@PresentersScope
@Subcomponent(modules = PresentersModule.class)
public interface PresentersComponent {
    void inject(MainActivity mainActivity);
    void inject(DetailNewsActivity detailPayloadActivity);
}
