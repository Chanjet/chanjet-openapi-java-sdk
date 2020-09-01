package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 代客下单
 * @author: zsc
 * @create: 2020/8/24 4:05 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateOrderContent extends AbstractChanjetContent {
    private static final long serialVersionUID = -2022889495058394913L;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 服务商登录密码
     */
    private String agentPwd;
    /**
     * 服务商支付密码
     */
    private String agentPayPwd;
    /**
     * 服务商编码
     */
    private String agentCode;
    /**
     * 订单描述
     */
    private String description;
    /**
     * 推荐人
     */
    private String refereeName;
    /**
     * 第三方订单号
     */
    private String thirdOrderNo;
}
