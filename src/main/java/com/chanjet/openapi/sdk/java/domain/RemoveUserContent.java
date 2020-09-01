package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 企业内移除用户
 * @author: zsc
 * @create: 2020/8/24 4:19 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RemoveUserContent extends AbstractChanjetContent {
    private static final long serialVersionUID = 8073618167147388759L;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 第三方用户ID
     */
    private String thirdPlatformUserId;
}
