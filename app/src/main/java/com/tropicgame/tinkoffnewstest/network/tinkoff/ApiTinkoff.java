package com.tropicgame.tinkoffnewstest.network.tinkoff;


import com.tropicgame.tinkoffnewstest.common.Const;
import com.tropicgame.tinkoffnewstest.network.response.NewsDetailsResponse;
import com.tropicgame.tinkoffnewstest.network.response.NewsItemsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by xpusher on 4/5/2018.
 */

public interface ApiTinkoff {
    @GET("v1/news/")
    Call<NewsItemsResponse> loadItemsNews(@Header("Cache-Control") String cacheControl);

    @GET("v1/news_content/")
    Call<NewsDetailsResponse> loadDetailsNews(@Header("Cache-Control") String cacheControl, @Query(Const.ID) String id);

}
