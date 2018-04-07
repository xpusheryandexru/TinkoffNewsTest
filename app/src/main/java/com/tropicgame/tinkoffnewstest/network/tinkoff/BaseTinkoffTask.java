package com.tropicgame.tinkoffnewstest.network.tinkoff;

import com.tropicgame.tinkoffnewstest.common.network.ApiException;
import com.tropicgame.tinkoffnewstest.common.network.BaseObservable;

import java.io.IOException;
import java.util.concurrent.Executor;

import io.reactivex.Scheduler;
import retrofit2.Call;
import retrofit2.Response;


public abstract class BaseTinkoffTask<P, Result> extends BaseObservable<P, Result> {

    private ApiTinkoff apiTinkoff;

    public BaseTinkoffTask(Executor executorHttp, Scheduler uiScheduler, ApiTinkoff apiTinkoff) {
        super(executorHttp, uiScheduler);
        this.apiTinkoff = apiTinkoff;
    }

    protected ApiTinkoff getApi() {
        return apiTinkoff;
    }

    protected <Res> Res executeCall(Call<Res> call) {
        try {
            Response<Res> resResponse = call.execute();
            if(resResponse.isSuccessful()) {
                return resResponse.body();
            } else {
                String body = resResponse.errorBody().string();
                throw new ApiException(body, resResponse.code());
            }
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), 0);

        }
    }

}
