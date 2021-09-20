package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 获取租户token
 * @author zsc
 * @create 2020/8/24 4:19 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetTenantTokenContent extends AbstractChanjetContent {
    private static final long serialVersionUID = 3926907263041856233L;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 畅捷通产品名称
     */
    private String appName;
    /**
     * 授权范围，默认auth_all
     */
    private String scope = "auth_all";
}
