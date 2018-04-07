package com.tropicgame.tinkoffnewstest;

import android.app.Application;

import com.tropicgame.tinkoffnewstest.dagger.components.AppComponent;
import com.tropicgame.tinkoffnewstest.dagger.components.DaggerAppComponent;

public class TinkoffNewsApp extends Application {

    private static TinkoffNewsApp instance;
    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        applicationComponent = DaggerAppComponent.create();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static void setInstance(TinkoffNewsApp instance) {
        TinkoffNewsApp.instance = instance;
    }
    public static TinkoffNewsApp getInstance() {
        return instance;
    }

}
