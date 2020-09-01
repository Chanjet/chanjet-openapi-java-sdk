package com.chanjet.openapi.sdk.java.request;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.CreateOrderResponse;

/**
 * 代客下单
 * @author: zsc
 * @create: 2020/8/24 4:00 下午
 **/
public class CreateOrderRequest extends AbstractChanjetRequest<CreateOrderResponse> {
    @Override
    public Class<CreateOrderResponse> getResponseClass() {
        return CreateOrderResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
