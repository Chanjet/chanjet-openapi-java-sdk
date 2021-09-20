package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.RemoveUserResponse;

/**
 * 集成模块模式，企业内移除用户请求
 *
 * @author zsc
 * @create 2020/8/24 4:19 下午
 **/
public class RemoveUserRequest extends AbstractChanjetRequest<RemoveUserResponse> {
    @Override
    public Class<RemoveUserResponse> getResponseClass() {
        return RemoveUserResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getRequestUri() {
        return "/financial/orgAndUser/removeUser";
    }
}
