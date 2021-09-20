package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 获取用户token
 * @author zsc
 * @create 2020/8/24 4:20 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetUserTokenContent extends AbstractChanjetContent {
    private static final long serialVersionUID = -5126668713954206717L;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 第三方用户ID
     */
    private String thirdPlatformUserId;
    /**
     * 畅捷通产品名称
     */
    private String appName;
    /**
     * 授权范围，默认auth_all
     */
    private String scope = "auth_all";
}
