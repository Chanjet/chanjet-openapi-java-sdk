package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.CreateTenantResponse;

/**
 * 集成模块模式，创建租户请求
 *
 * @author zsc
 * @create 2020/8/21 1:41 下午
 **/
public class CreateTenantRequest extends AbstractChanjetRequest<CreateTenantResponse> {
    @Override
    public Class<CreateTenantResponse> getResponseClass() {
        return CreateTenantResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getRequestUri() {
        return "/financial/orgAndUser/createTenant";
    }
}
