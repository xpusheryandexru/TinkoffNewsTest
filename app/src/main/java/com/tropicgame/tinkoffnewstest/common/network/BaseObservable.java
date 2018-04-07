package com.tropicgame.tinkoffnewstest.common.network;

import org.reactivestreams.Subscriber;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xpusher on 4/5/2018.
 */

public abstract class BaseObservable<Params, Result> {
    private Executor executorHttp;
    private Scheduler uiScheduler;
    private Disposable disposable;

    public BaseObservable(Executor executorHttp, Scheduler uiScheduler) {
        this.executorHttp = executorHttp;
        this.uiScheduler= uiScheduler;
    }

    protected abstract Observable<Result> prepareObservable(Params var1);

    public void cancel() {
        if(this.disposable != null && !this.disposable.isDisposed()) {
            this.disposable.dispose();
            this.disposable = null;
        }

    }

    public void execute(Params params, final Subscriber<Result> subscriber) {
        this.createObservable(params).subscribe(new Observer<Result>() {
            public void onSubscribe(@NonNull Disposable d) {
                BaseObservable.this.disposable = d;
            }

            public void onNext(@NonNull Result result) {
                subscriber.onNext(result);
            }

            public void onError(@NonNull Throwable e) {
                subscriber.onError(e);
            }

            public void onComplete() {
                subscriber.onComplete();
            }
        });
    }

    private Observable<Result> createObservable(Params params) {
        this.cancel();
        return this.prepareObservable(params)
                .subscribeOn(this.getExecutionScheduler())
                .materialize()
                .observeOn(this.getObserveScheduler())
                .dematerialize();
    }

    public void execute(Params params) {
        this.disposable = this.createObservable(params).subscribe();
    }

    protected Scheduler getExecutionScheduler() {
        return Schedulers.from(executorHttp);
    }

    protected Scheduler getObserveScheduler() {
        //return  AndroidSchedulers.mainThread();
        return uiScheduler;
    }
}
