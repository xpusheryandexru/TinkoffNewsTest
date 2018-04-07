package com.tropicgame.tinkoffnewstest.network.tinkoff;

import android.content.Context;

import com.tropicgame.tinkoffnewstest.common.network.BaseRetrofit;

import javax.inject.Inject;

/**
 * Created by xpusher on 4/5/2018.
 */

public class ClientTinkoff extends BaseRetrofit<ApiTinkoff> {

    @Inject
    public ClientTinkoff(Context context) {
        super("https://api.tinkoff.ru/",context);
    }


    @Override
    public Class<ApiTinkoff> apiClass() {
        return ApiTinkoff.class;
    }


}
