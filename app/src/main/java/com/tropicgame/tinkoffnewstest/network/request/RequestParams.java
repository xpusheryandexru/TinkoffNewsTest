package com.tropicgame.tinkoffnewstest.network.request;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by xpusher on 4/5/2018.
 */

public class RequestParams extends HashMap<String, String> implements Serializable {
    public RequestParams() {
    }

    public RequestParams addParam(String key, Object value) {
        this.put(key, String.valueOf(value));
        return this;
    }
}