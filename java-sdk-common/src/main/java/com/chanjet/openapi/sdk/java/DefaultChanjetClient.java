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
     * @param serverUrl 开放平台接口调用地址
     * @param appKey    开放平台appKey
     * @param appSecret 开放平台appSecret
     */
    public DefaultChanjetClient(String serverUrl, String appKey, String appSecret) {
        super(serverUrl, appKey, appSecret);
    }

    /**
     * @param serverUrl 开放平台接口调用地址
     * @param appKey    开放平台appKey
     * @param appSecret 开放平台appSecret
     * @param signKey   签名秘钥
     */
    public DefaultChanjetClient(String serverUrl, String appKey, String appSecret, String signKey) {
        super(serverUrl, appKey, appSecret, signKey);
    }

    /**
     * @param serverUrl      开放平台接口调用地址
     * @param appKey         开放平台appKey
     * @param appSecret      开放平台appSecret
     * @param connectTimeout 连接超时时间
     * @param readTimeout    读取超时时间
     */
    public DefaultChanjetClient(String serverUrl, String appKey, String appSecret, int connectTimeout, int readTimeout) {
        super(serverUrl, appKey, appSecret, connectTimeout, readTimeout);
    }

    /**
     * @param serverUrl        开放平台接口调用地址
     * @param appKey           开放平台appKey
     * @param appSecret        开放平台appSecret
     * @param connectTimeout   连接超时时间
     * @param readTimeout      读取超时时间
     * @param keepAliveTimeout keep-alive的时间
     */
    public DefaultChanjetClient(String serverUrl, String appKey, String appSecret, int connectTimeout, int readTimeout, int keepAliveTimeout) {
        super(serverUrl, appKey, appSecret, connectTimeout, readTimeout, keepAliveTimeout);
    }

    /**
     * @param serverUrl        开放平台接口调用地址
     * @param appKey           开放平台appKey
     * @param appSecret        开放平台appSecret
     * @param connectTimeout   连接超时时间
     * @param readTimeout      读取超时时间
     * @param keepAliveTimeout keep-alive的时间
     * @param signKey          签名秘钥
     */
    public DefaultChanjetClient(String serverUrl, String appKey, String appSecret, int connectTimeout, int readTimeout, int keepAliveTimeout, String signKey) {
        super(serverUrl, appKey, appSecret, connectTimeout, readTimeout, keepAliveTimeout, signKey);
    }


    /**
     * @param request 请求
     * @throws ChanjetApiException
     */
    @Override
    public void sign(ChanjetRequest request) throws ChanjetApiException {
        HttpMethod httpMethod = request.getHttpMethod();
        if (StringUtils.isNotBlank(this.getSignKey())) {
            String body = null;
            if (httpMethod.equals(HttpMethod.POST) || httpMethod.equals(HttpMethod.PUT)) {
                body = new Gson().toJson(request.getBizContent());
            }
            String timestamp = String.valueOf(System.currentTimeMillis());
            try {
                String signature = SignUtils.sign(body, this.getAppKey(), this.getSignKey(), timestamp);
                request.addHeader(ChanjetConstants.SIGN_KEY, signature);
                request.addHeader(ChanjetConstants.TIMESTAMP_KEY, timestamp);
            } catch (Exception e) {
                throw new ChanjetApiException("加签失败", e);
            }
        }
    }
}
