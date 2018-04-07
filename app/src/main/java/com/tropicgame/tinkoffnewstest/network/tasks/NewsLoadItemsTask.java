package com.tropicgame.tinkoffnewstest.network.tasks;

import com.tropicgame.tinkoffnewstest.common.Const;
import com.tropicgame.tinkoffnewstest.network.response.NewsItemsResponse;
import com.tropicgame.tinkoffnewstest.network.tinkoff.ApiTinkoff;
import com.tropicgame.tinkoffnewstest.network.tinkoff.BaseTinkoffTask;
import com.tropicgame.tinkoffnewstest.network.request.RequestParams;
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

public class NewsLoadItemsTask extends BaseTinkoffTask<RequestParams,NewsItemsResponse> {

    @Inject
    public NewsLoadItemsTask(Executor executorHttp, Scheduler uiScheduler, ApiTinkoff apiTinkoff) {
        super(executorHttp, uiScheduler, apiTinkoff);
    }

    @Override
    protected Observable<NewsItemsResponse> prepareObservable(final RequestParams var1) {
        return Observable.create(new ObservableOnSubscribe<NewsItemsResponse>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<NewsItemsResponse> subscriber) {
                try {
                    //subscriber.onNext(executeCall(getApi().loadItemsNews(null)));
                    subscriber.onNext(executeCall(getApi().loadItemsNews(var1.get(Const.KEY_CACHE_CONTROL))));
                    subscriber.onComplete();
                }catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }

}
