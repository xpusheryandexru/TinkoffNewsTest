package com.tropicgame.tinkoffnewstest.common.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.TimeUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xpusher on 4/5/2018.
 */

public abstract class BaseRetrofit<T> {
    private T api;
    private Context context;
    public BaseRetrofit(String baseUrl, Context context){
        this.context=context;
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(new File(context.getCacheDir(), "http"), cacheSize);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR);
        //clientBuilder.addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE);
        clientBuilder.cache(cache);

        Gson gson = this.createGsonBuilder().create();
        if(gson == null)
            gson = new Gson();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.api=retrofit.create(apiClass());

    }

    public abstract Class<T> apiClass();

    public T getApi() {
        return api;
    }

    protected GsonBuilder createGsonBuilder() {
        return (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    private final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            CacheControl cacheControl=new CacheControl.Builder()
                    .maxAge(7, TimeUnit.DAYS)
                    .build();
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public, "+cacheControl.toString())
                    .build();
        }
    };

    private final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!isOnline()) {
                request = request.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached")
                        .build();
            }
            return chain.proceed(request);
        }
    };
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
