package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetTenantTokenResponse;

/**
 * 集成模块模式，获取租户token请求
 *
 * @author zsc
 * @create 2020/8/24 4:19 下午
 **/
public class GetTenantTokenRequest extends AbstractChanjetRequest<GetTenantTokenResponse> {
    @Override
    public Class<GetTenantTokenResponse> getResponseClass() {
        return GetTenantTokenResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
