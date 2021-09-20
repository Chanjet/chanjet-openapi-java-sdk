package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.UserResponse;

/**
 * @author: zsc
 * @create: 2020/11/11 11:19 上午
 **/

public class UserRequest extends AbstractChanjetRequest<UserResponse> {

    @Override
    public Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getRequestUri() {
        return "/accounting/cia/api/v1/user";
    }
}
