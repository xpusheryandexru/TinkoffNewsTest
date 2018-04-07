package com.tropicgame.tinkoffnewstest.dagger.modules;

import android.content.Context;

import com.tropicgame.tinkoffnewstest.TinkoffNewsApp;
import com.tropicgame.tinkoffnewstest.network.tinkoff.ApiTinkoff;
import com.tropicgame.tinkoffnewstest.network.tinkoff.ClientTinkoff;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Executor provideHttpExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    public Scheduler provideUiThread() {
        return  AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    public ApiTinkoff provideApiTinkoff(ClientTinkoff clientClientTinkoff){
        return clientClientTinkoff.getApi();
    }

    @Provides
    @Singleton
    public Context provideAppContext(){
        return TinkoffNewsApp.getInstance().getApplicationContext();
    }

}
