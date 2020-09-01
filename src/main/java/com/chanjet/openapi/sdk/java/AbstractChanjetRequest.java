package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.common.ChanjetConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zsc
 * @create: 2020/7/31 10:40 上午
 **/
public abstract class AbstractChanjetRequest<T extends ChanjetResponse> implements ChanjetRequest<T> {

    private Map<String, String> queryParams = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private String contentType = "application/json";
    private String openToken;
    private String appKey;
    private String appSecret;
    private String requestUri;
    private ChanjetContent bizContent;

    @Override
    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getOpenToken() {
        return openToken;
    }

    public void setOpenToken(String openToken) {
        this.openToken = openToken;
    }

    @Override
    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public void addQueryParams(Map<String, String> queryParams) {
        this.queryParams.putAll(queryParams);
    }

    @Override
    public void addQueryParam(String key, String value) {
        this.queryParams.put(key, value);
    }

    @Override
    public Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    @Override
    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    @Override
    public void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    @Override
    public Map<String, String> getHeaders() {
        this.headers.put(ChanjetConstants.APP_KEY, this.appKey);
        this.headers.put(ChanjetConstants.APP_SECRET, this.appSecret);
        this.headers.put(ChanjetConstants.OPEN_TOKEN, this.openToken);
        this.headers.put(ChanjetConstants.CONTENT_TYPE, this.contentType);
        return this.headers;
    }

    @Override
    public void setBizContent(ChanjetContent bizContent) {
        this.bizContent = bizContent;
    }

    @Override
    public ChanjetContent getBizContent() {
        return this.bizContent;
    }
}
