package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import com.chanjet.openapi.sdk.java.common.ErrorInfo;
import lombok.*;

/**
 * 集成模块模式，获取用户token响应
 *
 * @author zsc
 * @create 2020/8/24 4:20 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetUserTokenResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = -9048579901126715434L;
    /**
     * 判断是否成功
     */
    private Boolean result;
    /**
     * 错误信息
     */
    private ErrorInfo error;
    /**
     * 业务返回值
     */
    private Value value;

    @Data
    public static class Value {
        /**
         * 访问token，也就是openToken
         */
        private String accessToken;

        /**
         * 刷新你令牌
         */
        private String refreshToken;

        /**
         * 授权范围
         */
        //权限范围，默认all
        private String scope;

        /**
         * 过期时间
         */
        private long expiresIn;

        /**
         * 用户ID
         */
        private String userId;

        /**
         * 企业ID
         */
        private String orgId;

        /**
         * 应用名
         */
        private String appName;
        /**
         * 刷新令牌过期时间
         */
        private long refreshExpiresIn;
        /**
         * T+产品部分接口需要传在Cookie中的值
         */
        private String sid;
    }

}
