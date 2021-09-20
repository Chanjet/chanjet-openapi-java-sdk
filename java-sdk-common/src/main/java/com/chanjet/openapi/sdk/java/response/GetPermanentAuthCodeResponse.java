package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import lombok.Data;

/**
 * @author: zsc
 * @create: 2020/11/5 3:50 下午
 **/
@Data
public class GetPermanentAuthCodeResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = 3545973292845315394L;
    /**
     * 判断是否成功，200为成功
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 业务返回值
     */
    private Result result;

    @Data
    public static class Result {
        /**
         * 企业凭证
         */
        private String permanentAuthCode;
        /**
         * 企业ID
         */
        private String orgId;
    }
}
