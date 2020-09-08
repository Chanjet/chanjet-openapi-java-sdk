package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import com.chanjet.openapi.sdk.java.common.ErrorInfo;
import lombok.*;

/**
 * 集成模块模式，企业内移除用户响应
 *
 * @author zsc
 * @create 2020/8/24 4:18 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RemoveUserResponse extends AbstractChanjetResponse {
    private static final long serialVersionUID = 2781114032633706965L;
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
         * 畅捷通企业ID
         */
        private String orgId;
        /**
         * 畅捷通用户ID
         */
        private String userId;
    }
}
