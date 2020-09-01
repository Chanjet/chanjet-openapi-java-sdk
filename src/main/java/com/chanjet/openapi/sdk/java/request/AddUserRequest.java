package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.AddUserResponse;

/**
 * 企业内添加用户
 * @author: zsc
 * @create: 2020/8/24 4:16 下午
 **/
public class AddUserRequest extends AbstractChanjetRequest<AddUserResponse> {
    @Override
    public Class<AddUserResponse> getResponseClass() {
        return AddUserResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
