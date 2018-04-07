package com.tropicgame.tinkoffnewstest.network.response;

import com.tropicgame.tinkoffnewstest.common.modeles.BasePayLoad;
import com.tropicgame.tinkoffnewstest.modeles.NewsDetails;

public class NewsDetailsResponse extends BasePayLoad{
    private NewsDetails payload;

    public NewsDetailsResponse(){

    }

    public NewsDetailsResponse(String content){
        payload=new NewsDetails(content);

    }


    public NewsDetails getPayload() {
        return payload;
    }
}
