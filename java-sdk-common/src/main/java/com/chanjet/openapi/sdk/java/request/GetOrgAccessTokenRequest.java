package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.GetOrgAccessTokenResponse;

/**
 * @author: zsc
 * @create: 2020/11/5 3:43 下午
 **/
public class GetOrgAccessTokenRequest extends AbstractChanjetRequest<GetOrgAccessTokenResponse> {
    @Override
    public Class<GetOrgAccessTokenResponse> getResponseClass() {
        return GetOrgAccessTokenResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getRequestUri() {
        return "/auth/orgAuth/getOrgAccessToken";
    }
}
