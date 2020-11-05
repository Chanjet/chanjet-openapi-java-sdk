package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetTokenByPermanentCodeResponse;

/**
 * @author: zsc
 * @create: 2020/11/5 3:44 下午
 **/
public class GetTokenByPermanentCodeRequest extends AbstractChanjetRequest<GetTokenByPermanentCodeResponse> {
    @Override
    public Class<GetTokenByPermanentCodeResponse> getResponseClass() {
        return GetTokenByPermanentCodeResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}