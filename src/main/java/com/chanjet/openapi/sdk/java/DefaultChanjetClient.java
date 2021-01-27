package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.common.ChanjetConstants;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.utils.SignUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

/**
 * 默认畅捷通开放平台API调用客户端
 *
 * @author zsc
 * @create 2020/7/31 4:52 下午
 **/
public class DefaultChanjetClient extends AbstractChanjetClient {
    /**
     * @param serverUrl 开放平台网关地址
     */
    public DefaultChanjetClient(String serverUrl) {
        super(serverUrl);
    }

    /**
     * @param serverUrl 开放平台网关地址
     * @param signKey   加签秘钥
     */
    public DefaultChanjetClient(String serverUrl, String signKey) {
        super(serverUrl, signKey);
    }

    public DefaultChanjetClient(String serverUrl, int connectTimeout, int readTimeout) {
        super(serverUrl, connectTimeout, readTimeout);
    }

    public DefaultChanjetClient(String serverUrl, int connectTimeout, int readTimeout, int keepAliveTimeout) {
        super(serverUrl, connectTimeout, readTimeout, keepAliveTimeout);
    }

    public DefaultChanjetClient(String serverUrl, int connectTimeout, int readTimeout, int keepAliveTimeout, String signKey) {
        super(serverUrl, connectTimeout, readTimeout, keepAliveTimeout, signKey);
    }

    @Override
    public void sign(ChanjetRequest request, String signKey) throws ChanjetApiException {
        HttpMethod httpMethod = request.getHttpMethod();
        if (StringUtils.isNotBlank(signKey)) {
            String body = null;
            if (httpMethod.equals(HttpMethod.POST) || httpMethod.equals(HttpMethod.PUT)) {
                body = new Gson().toJson(request.getBizContent());
            }
            String timestamp = String.valueOf(System.currentTimeMillis());
            try {
                String signature = SignUtils.sign(body, request.getAppKey(), signKey, timestamp);
                request.addHeader(ChanjetConstants.SIGN_KEY, signature);
                request.addHeader(ChanjetConstants.TIMESTAMP_KEY, timestamp);
            } catch (Exception e) {
                throw new ChanjetApiException("加签失败", e);
            }
        }
    }
}
