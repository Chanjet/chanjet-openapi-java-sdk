package com.chanjet.openapi.sdk.java.starter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: zsc
 * @create: 2021/9/20 8:46 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("chanjet.client")
public class ChanjetSdkConfigProperties {

    /**
     * 开放平台的调用地址
     */
    private String serverUrl;
    /**
     * 开放平台的appKey
     */
    private String appKey;
    /**
     * 开放平台的appSecret
     */
    private String appSecret;
    /**
     * http连接超时,单位ms
     */
    private int connectTimeout = 3000;
    /**
     * http读取超时,单位ms
     */
    private int readTimeout = 15000;
    /**
     * 加签秘钥
     */
    private String signKey;
    /**
     * keep-alive，单位s
     */
    private int keepAliveTimeout = 60;
}
