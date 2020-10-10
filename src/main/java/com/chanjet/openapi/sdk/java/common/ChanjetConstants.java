package com.chanjet.openapi.sdk.java.common;

/**
 * @author zsc
 * @create 2020/7/31 1:06 下午
 **/
public class ChanjetConstants {
    private ChanjetConstants() {
    }
    public static final String APP_KEY = "appKey";
    public static final String APP_SECRET = "appSecret";
    public static final String OPEN_TOKEN = "openToken";
    public static final String CONTENT_TYPE = "Content-Type";
    /**
     * 默认时间格式
     **/
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date默认时区
     **/
    public static final String DATE_TIMEZONE = "GMT+8";
    /**
     * SDK版本号
     */
    public static final String SDK_VERSION = "chanjet-sdk-java-dynamicVersionNo";
    public static final String SIGN_KEY = "signature";
    public static final String TIMESTAMP_KEY = "timestamp";
}
