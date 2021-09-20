package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetPermanentAuthCodeResponse;

/**
 * @author: zsc
 * @create: 2020/11/5 3:44 下午
 **/
public class GetPermanentAuthCodeRequest extends AbstractChanjetRequest<GetPermanentAuthCodeResponse> {
    @Override
    public Class<GetPermanentAuthCodeResponse> getResponseClass() {
        return GetPermanentAuthCodeResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getRequestUri() {
        return "/auth/orgAuth/getPermanentAuthCode";
    }
}
