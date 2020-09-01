package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 产品试用
 * @author: zsc
 * @create: 2020/8/24 4:08 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TrailProductContent extends AbstractChanjetContent {
    private static final long serialVersionUID = 8099046574826506586L;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 畅捷通的产品code，线下沟通获取
     */
    private String productId;
    /**
     * 服务商编码
     */
    private String agentCode;
    /**
     * 推荐人
     */
    private String refereeName;
}
