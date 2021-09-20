package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetLoginUrlResponse;

/**
 * 获取单点登录地址
 *
 * @author zsc
 * @create 2020/8/24 5:11 下午
 **/
public class GetLoginUrlRequest extends AbstractChanjetRequest<GetLoginUrlResponse> {
    @Override
    public Class<GetLoginUrlResponse> getResponseClass() {
        return GetLoginUrlResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getRequestUri() {
        return "/authSite/sso/getLoginUrl";
    }
}
