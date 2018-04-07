package com.tropicgame.tinkoffnewstest.common.network;

/**
 * Created by xpusher on 4/5/2018.
 */

public class ApiException extends RuntimeException {
    private int code = 0;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
