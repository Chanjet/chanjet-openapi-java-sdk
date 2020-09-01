package com.chanjet.openapi.sdk.java;

/**
 * 默认畅捷通开放平台API调用客户端
 * @author: zsc
 * @create: 2020/7/31 4:52 下午
 **/
public class DefaultChanjetClient extends AbstractChanjetClient {
    public DefaultChanjetClient(String serverUrl) {
        super(serverUrl);
    }

    public DefaultChanjetClient(String serverUrl, int connectTimeout, int readTimeout) {
        super(serverUrl, connectTimeout, readTimeout);
    }

    public DefaultChanjetClient(String serverUrl, int connectTimeout, int readTimeout, int keepAliveTimeout) {
        super(serverUrl, connectTimeout, readTimeout, keepAliveTimeout);
    }
}
