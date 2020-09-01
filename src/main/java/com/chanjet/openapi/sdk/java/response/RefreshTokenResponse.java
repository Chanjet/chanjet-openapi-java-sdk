package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import com.google.gson.annotations.SerializedName;
import lombok.*;

/**
 * 刷新token
 * @author: zsc
 * @create: 2020/8/24 5:46 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RefreshTokenResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = -3670472011629372150L;
    private String code;

    private String message;

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
    }
}
