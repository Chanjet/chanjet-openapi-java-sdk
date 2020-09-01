package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 企业内添加用户
 * @author: zsc
 * @create: 2020/8/24 4:16 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddUserContent extends AbstractChanjetContent {
    private static final long serialVersionUID = -611997600081497088L;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 第三方用户ID
     */
    private String thirdPlatformUserId;
}
