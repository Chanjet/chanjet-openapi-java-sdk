package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author: zsc
 * @create: 2020/11/5 3:55 下午
 **/
@Data
public class GetTokenByPermanentCodeResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = 3545973292845315394L;
    /**
     * 错误码，200为成功，其余均为失败，详情参考开放平台接口错误码类表
     */
    private String code;
    /**
     * 错误响应信息
     */
    private String message;
    /**
     * 响应结果
     */
    private Result result;

    @Data
    public static class Result {
        /**
         * 访问token，也就是openToken
         */
        @SerializedName("access_token")
        private String accessToken;

        /**
         * 刷新你令牌
         */
        @SerializedName("refresh_token")
        private String refreshToken;

        /**
         * 授权范围
         */
        //权限范围，默认all
        private String scope;

        /**
         * 过期时间
         */
        @SerializedName("expires_in")
        private long expiresIn;

        /**
         * 用户ID
         */
        @SerializedName("user_id")
        private String userId;

        /**
         * 企业ID
         */
        @SerializedName("org_id")
        private String orgId;

        /**
         * 应用名
         */
        @SerializedName("app_name")
        private String appName;
        /**
         * 刷新令牌过期时间
         */
        @SerializedName("refresh_expires_in")
        private long refreshExpiresIn;
        /**
         * T+产品部分接口需要传在Cookie中的值
         */
        @SerializedName("sid")
        private String sid;
        /**
         * 用户永久授权码
         */
        @SerializedName("user_auth_permanent_code")
        private String userAuthPermanentCode;
    }
}
