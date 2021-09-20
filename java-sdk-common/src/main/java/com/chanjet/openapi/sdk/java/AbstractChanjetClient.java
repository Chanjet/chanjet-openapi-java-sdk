package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.utils.ChanjetLogger;
import com.chanjet.openapi.sdk.java.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

/**
 * 畅捷通开放平台客户端抽象
 *
 * @author zsc
 * @create 2020/7/31 1:24 下午
 **/
public abstract class AbstractChanjetClient implements ChanjetClient {
    /**
     * 链接超时的默认时间，单位ms
     */
    private static final int CONNECT_TIMEOUT = 3000;
    /**
     * 读取超时的默认时间，单位ms
     */
    private static final int READ_TIMEOUT = 15000;
    /**
     * 保持链接的默认时间，单位s
     */
    private static final int KEEP_ALIVE_TIMEOUT = 60;

    /**
     * 开放平台的调用地址
     */
    private final String serverUrl;
    /**
     * 开放平台的appKey
     */
    private final String appKey;
    /**
     * 开放平台的appSecret
     */
    private final String appSecret;
    /**
     * http链接超时
     */
    private final int connectTimeout;
    /**
     * http读取超时
     */
    private final int readTimeout;
    /**
     * 加签秘钥
     */
    private String signKey;

    public AbstractChanjetClient(String serverUrl, String appKey, String appSecret) {
        this(serverUrl, appKey, appSecret, CONNECT_TIMEOUT, READ_TIMEOUT, KEEP_ALIVE_TIMEOUT);
    }

    public AbstractChanjetClient(String serverUrl, String appKey, String appSecret, String signKey) {
        this(serverUrl, appKey, appSecret, CONNECT_TIMEOUT, READ_TIMEOUT, KEEP_ALIVE_TIMEOUT, signKey);
    }

    public AbstractChanjetClient(String serverUrl, String appKey, String appSecret, int connectTimeout,
                                 int readTimeout) {
        this(serverUrl, appKey, appSecret, connectTimeout, readTimeout, KEEP_ALIVE_TIMEOUT);
    }

    public AbstractChanjetClient(String serverUrl, String appKey, String appSecret, int connectTimeout,
                                 int readTimeout, int keepAliveTimeout) {
        this.serverUrl = serverUrl;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.appKey = appKey;
        this.appSecret = appSecret;
        HttpUtils.setKeepAliveTimeout(keepAliveTimeout);
    }

    public AbstractChanjetClient(String serverUrl, String appKey, String appSecret, int connectTimeout,
                                 int readTimeout, int keepAliveTimeout, String signKey) {
        this.serverUrl = serverUrl;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.signKey = signKey;
        this.appKey = appKey;
        this.appSecret = appSecret;
        HttpUtils.setKeepAliveTimeout(keepAliveTimeout);
    }

    protected String getServerUrl() {
        return serverUrl;
    }

    protected String getAppKey() {
        return appKey;
    }

    protected String getAppSecret() {
        return appSecret;
    }

    protected int getConnectTimeout() {
        return connectTimeout;
    }

    protected int getReadTimeout() {
        return readTimeout;
    }

    protected String getSignKey() {
        return signKey;
    }

    @Override
    public <T extends ChanjetResponse> T execute(ChanjetRequest<T> request) throws ChanjetApiException {
        //发起调用
        HttpResponse httpResponse = invoke(request);
        try {
            return new Gson().fromJson(httpResponse.getBody(), request.getResponseClass());
        } catch (Exception e) {
            ChanjetLogger.logBizError(request.getResponseClass().toString() + "--响应实体转型错误", e);
            throw new ChanjetApiException("响应实体转型错误", e);
        }
    }

    @Override
    public HttpResponse doExecute(ChanjetRequest<ChanjetResponse> request) throws ChanjetApiException {
        //发起调用
        return invoke(request);
    }

    public <T extends ChanjetResponse> HttpResponse invoke(ChanjetRequest<T> request) throws ChanjetApiException {
        HttpResponse httpResponse;
        try {
            Map<String, String> headers = buildHeaders(request.getHeaders());
            ChanjetLogger.logBizCommonParam(request.getAppKey());
            ChanjetLogger.logHttpRequest(request.getHttpMethod().name(), serverUrl + request.getRequestUri(),
                    request.getQueryParams(), headers, new Gson().toJson(request.getBizContent()));
            switch (request.getHttpMethod()) {
                case GET:
                    httpResponse = doGet(request);
                    break;
                case POST:
                    httpResponse = doPost(request);
                    break;
                case DELETE:
                    httpResponse = doDelete(request);
                    break;
                case PUT:
                    httpResponse = doPut(request);
                    break;
                default:
                    throw new ChanjetApiException();
            }
            ChanjetLogger.logHttpResponse(request.getHttpMethod().name(), serverUrl + request.getRequestUri(),
                    request.getQueryParams(), httpResponse.getHeaders(), httpResponse.getBody());
        } catch (IOException e) {
            ChanjetLogger.logBizError("调用API失败", e);
            throw new ChanjetApiException("调用API失败", e);
        }
        return httpResponse;
    }

    public <T extends ChanjetResponse> HttpResponse doPost(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        sign(request);
        Map<String, String> headers = buildHeaders(request.getHeaders());
        String body = new Gson().toJson(request.getBizContent());
        return HttpUtils.doPost(this.serverUrl + request.getRequestUri(), headers, request.getQueryParams(),
                request.getContentType(), body, this.connectTimeout, this.readTimeout, null, 0);
    }

    public <T extends ChanjetResponse> HttpResponse doGet(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        sign(request);
        Map<String, String> headers = buildHeaders(request.getHeaders());
        return HttpUtils.doGet(this.serverUrl + request.getRequestUri(), headers,
                request.getQueryParams(), request.getContentType(), this.connectTimeout, this.readTimeout);
    }

    public <T extends ChanjetResponse> HttpResponse doDelete(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        sign(request);
        Map<String, String> headers = buildHeaders(request.getHeaders());
        return HttpUtils.doDelete(this.serverUrl + request.getRequestUri(), headers,
                request.getQueryParams(), request.getContentType(), this.connectTimeout, this.readTimeout);
    }

    public <T extends ChanjetResponse> HttpResponse doPut(ChanjetRequest<T> request) throws IOException, ChanjetApiException {
        sign(request);
        Map<String, String> headers = buildHeaders(request.getHeaders());
        String body = new Gson().toJson(request.getBizContent());
        return HttpUtils.doPut(this.serverUrl + request.getRequestUri(), headers, request.getQueryParams(),
                request.getContentType(), body, this.connectTimeout, this.readTimeout, null, 0);
    }

    /**
     * 构造请求头
     *
     * @param requestHeaders
     * @return
     */
    private Map<String, String> buildHeaders(Map<String, String> requestHeaders) {
        requestHeaders.put(APP_KEY, this.appKey);
        requestHeaders.put(APP_SECRET, this.appSecret);
        return requestHeaders;
    }

    /**
     * 加签方法
     *
     * @param request 请求
     * @return 返回签名
     */
    protected abstract void sign(ChanjetRequest request) throws ChanjetApiException;
}
