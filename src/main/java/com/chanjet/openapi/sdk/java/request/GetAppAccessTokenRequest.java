package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetAppAccessTokenResponse;

/**
 * @author: zsc
 * @create: 2020/11/5 3:43 下午
 **/
public class GetAppAccessTokenRequest extends AbstractChanjetRequest<GetAppAccessTokenResponse> {
    @Override
    public Class<GetAppAccessTokenResponse> getResponseClass() {
        return GetAppAccessTokenResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
