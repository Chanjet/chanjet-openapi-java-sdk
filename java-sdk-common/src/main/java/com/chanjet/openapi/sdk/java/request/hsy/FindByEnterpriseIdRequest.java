package com.chanjet.openapi.sdk.java.request.hsy;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.hsy.FindByEnterpriseIdResponse;

/**
 * 获取好生意账套列表请求
 *
 * @author: zsc
 * @create: 2020/11/11 1:02 下午
 **/
public class FindByEnterpriseIdRequest extends AbstractChanjetRequest<FindByEnterpriseIdResponse> {

    @Override
    public Class<FindByEnterpriseIdResponse> getResponseClass() {
        return FindByEnterpriseIdResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
