package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.RefreshTokenResponse;

/**
 * 刷新token
 * @author: zsc
 * @create: 2020/8/24 5:45 下午
 **/
public class RefreshTokenRequest extends AbstractChanjetRequest<RefreshTokenResponse> {
    @Override
    public Class<RefreshTokenResponse> getResponseClass() {
        return RefreshTokenResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
