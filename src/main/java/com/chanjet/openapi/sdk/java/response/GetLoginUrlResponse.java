package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import com.chanjet.openapi.sdk.java.common.ErrorInfo;
import lombok.*;

/**
 * 获取单点登录地址
 * @author: zsc
 * @create: 2020/8/24 5:11 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetLoginUrlResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = -2251817164938249223L;
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
         * 单点登录地址
         */
        private String loginUrl;
    }
}
