package com.chanjet.openapi.sdk.java.exception;

/**
 * @author zsc
 * @create 2020/7/31 1:20 下午
 **/
public class ChanjetApiException extends Exception{
    private static final long serialVersionUID = -238091758285157331L;

    private String errorMsg;

    public ChanjetApiException() {
        super();
    }

    public ChanjetApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChanjetApiException(String message) {
        super(message);
    }

    public ChanjetApiException(Throwable cause) {
        super(cause);
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
