package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;

/**
 * @author zsc
 * @create 2020/7/31 1:15 下午
 **/
public interface ChanjetClient {
    public static final String APP_KEY = "appKey";
    public static final String APP_SECRET = "appSecret";
    /**
     * 执行调用，返回json序列化后的对象
     *
     * @param <T>
     * @param request
     * @return
     * @throws ChanjetApiException
     */
    <T extends ChanjetResponse> T execute(ChanjetRequest<T> request) throws ChanjetApiException;

    /**
     * 指定调用，返回HttpResponse
     *
     * @param request
     * @return
     * @throws ChanjetApiException
     */
    HttpResponse doExecute(ChanjetRequest<ChanjetResponse> request) throws ChanjetApiException;
}
