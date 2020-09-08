package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.enums.HttpMethod;

import java.util.Map;

/**
 * @author zsc
 * @create 2020/7/30 5:10 下午
 **/
public interface ChanjetRequest<T extends ChanjetResponse> {
    /**
     * 得到当前API的响应结果类型
     *
     * @return 响应类型
     */
    Class<T> getResponseClass();

    /**
     * 获取当前请求的请求方式
     *
     * @return 请求方式
     */
    HttpMethod getHttpMethod();

    /**
     * 添加多个query参数
     *
     * @param queryParams query参数
     */
    void addQueryParams(Map<String, String> queryParams);

    /**
     * 添加单个query参数
     *
     * @param key
     * @param value
     */
    void addQueryParam(String key, String value);

    /**
     * 获取当前请求的query参数
     *
     * @return query参数
     */
    Map<String, String> getQueryParams();

    /**
     * 添加单个请求头参数
     *
     * @param key   请求头key值
     * @param value 请求头value值
     */
    void addHeader(String key, String value);

    /**
     * 添加多个请求头参数
     *
     * @param headers 请求头参数
     */
    void addHeaders(Map<String, String> headers);

    /**
     * 获取请求头
     *
     * @return
     */
    Map<String, String> getHeaders();

    /**
     * 获取请求uri
     *
     * @return
     */
    String getRequestUri();

    /**
     * 设置业务参数对象
     *
     * @param bizContent
     */
    void setBizContent(ChanjetContent bizContent);

    /**
     * 获取业务参数对象
     *
     * @return ChanjetContent 参数
     */
    ChanjetContent getBizContent();

    /**
     * 获取请求格式
     *
     * @return
     */
    String getContentType();

    /**
     * 设置请求格式
     */
    void setContentType(String contentType);

    String getAppKey();
}
