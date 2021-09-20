package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetTokenResponse;

/**
 * 应用入驻模式，获取token请求
 *
 * @author zsc
 * @create 2020/9/8 2:16 下午
 **/
public class GetTokenRequest extends AbstractChanjetRequest<GetTokenResponse> {

    @Override
    public Class<GetTokenResponse> getResponseClass() {
        return GetTokenResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getRequestUri() {
        return "/auth/getToken";
    }
}
