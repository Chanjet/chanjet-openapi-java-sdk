package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.TrailProductRequestResponse;

/**
 * 产品试用
 * @author: zsc
 * @create: 2020/8/24 4:07 下午
 **/
public class TrailProductRequest extends AbstractChanjetRequest<TrailProductRequestResponse> {
    @Override
    public Class<TrailProductRequestResponse> getResponseClass() {
        return TrailProductRequestResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
