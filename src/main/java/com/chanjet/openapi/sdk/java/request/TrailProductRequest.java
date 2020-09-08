package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.TrailProductResponse;

/**
 * 集成模块模式，产品试用请求
 *
 * @author zsc
 * @create 2020/8/24 4:07 下午
 **/
public class TrailProductRequest extends AbstractChanjetRequest<TrailProductResponse> {
    @Override
    public Class<TrailProductResponse> getResponseClass() {
        return TrailProductResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
