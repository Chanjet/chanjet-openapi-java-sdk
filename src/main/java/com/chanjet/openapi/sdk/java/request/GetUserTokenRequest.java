package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetUserTokenResponse;

/**
 * 集成模块模式，获取用户token请求
 *
 * @author zsc
 * @create 2020/8/24 4:20 下午
 **/
public class GetUserTokenRequest extends AbstractChanjetRequest<GetUserTokenResponse> {
    @Override
    public Class<GetUserTokenResponse> getResponseClass() {
        return GetUserTokenResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

}
