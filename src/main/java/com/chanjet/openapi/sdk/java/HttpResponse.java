package com.chanjet.openapi.sdk.java;

import java.util.Map;

/**
 * @author zsc
 * @create 2020/7/31 3:26 下午
 **/
public class HttpResponse {
    private int statusCode;
    private String body;
    private Map<String,String> headers;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "body='" + body + '\'' +
                ", headers=" + headers +
                '}';
    }
}
