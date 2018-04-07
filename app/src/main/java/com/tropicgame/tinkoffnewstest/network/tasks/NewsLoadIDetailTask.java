package com.tropicgame.tinkoffnewstest.network.tasks;

import com.tropicgame.tinkoffnewstest.common.Const;
import com.tropicgame.tinkoffnewstest.network.request.RequestParams;
import com.tropicgame.tinkoffnewstest.network.response.NewsDetailsResponse;
import com.tropicgame.tinkoffnewstest.network.tinkoff.ApiTinkoff;
import com.tropicgame.tinkoffnewstest.network.tinkoff.BaseTinkoffTask;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;

/**
 * Created by xpusher on 4/5/2018.
 */

public class NewsLoadIDetailTask extends BaseTinkoffTask<RequestParams,NewsDetailsResponse> {

    @Inject
    public NewsLoadIDetailTask(Executor executorHttp, Scheduler uiScheduler, ApiTinkoff apiTinkoff) {
        super(executorHttp, uiScheduler, apiTinkoff);
    }

    @Override
    protected Observable<NewsDetailsResponse> prepareObservable(final RequestParams var1) {
        return Observable.create(new ObservableOnSubscribe<NewsDetailsResponse>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<NewsDetailsResponse> subscriber) {
                try {


                    subscriber.onNext(executeCall(getApi()
                                        .loadDetailsNews(
                                                var1.get(Const.KEY_CACHE_CONTROL),
                                                var1.get(Const.KEY_ID)
                                        )));

                    subscriber.onComplete();
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }

}
