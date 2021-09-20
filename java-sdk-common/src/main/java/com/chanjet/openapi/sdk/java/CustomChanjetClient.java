package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;

import java.io.IOException;

/**
 * 客户化扩展
 * @author: zsc
 * @create: 2021/8/31 10:21 上午
 **/
public class CustomChanjetClient extends AbstractChanjetClient{


    public CustomChanjetClient(String serverUrl, String appKey, String appSecret) {
        super(serverUrl, appKey, appSecret);
    }

    @Override
    public <T extends ChanjetResponse> T execute(ChanjetRequest<T> request) throws ChanjetApiException {
        return super.execute(request);
    }

    @Override
    public HttpResponse doExecute(ChanjetRequest<ChanjetResponse> request) throws ChanjetApiException {
        return super.doExecute(request);
    }

    @Override
    public <T extends ChanjetResponse> HttpResponse invoke(ChanjetRequest<T> request) throws ChanjetApiException {
        return super.invoke(request);
    }

    @Override
    public <T extends ChanjetResponse> HttpResponse doPost(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        return super.doPost(request);
    }

    @Override
    public <T extends ChanjetResponse> HttpResponse doGet(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        return super.doGet(request);
    }

    @Override
    public <T extends ChanjetResponse> HttpResponse doDelete(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        return super.doDelete(request);
    }

    @Override
    public <T extends ChanjetResponse> HttpResponse doPut(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        return super.doPut(request);
    }

    @Override
    protected void sign(ChanjetRequest request) throws ChanjetApiException {

    }
}
