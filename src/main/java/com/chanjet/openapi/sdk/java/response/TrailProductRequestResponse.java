package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import com.chanjet.openapi.sdk.java.common.ErrorInfo;
import lombok.*;

/**
 * 产品试用
 * @author: zsc
 * @create: 2020/8/24 4:07 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TrailProductRequestResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = 6338197263676009276L;
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
         * 订单号
         */
        private String orderNo;
    }

}
