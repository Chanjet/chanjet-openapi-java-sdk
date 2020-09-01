package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;

/**
 * @author: zsc
 * @create: 2020/7/31 1:15 下午
 **/
public interface ChanjetClient {
    /**
     * @param <T>
     * @param request
     * @return
     * @throws ChanjetApiException
     */
    <T extends ChanjetResponse> T execute(ChanjetRequest<T> request) throws ChanjetApiException;
}
