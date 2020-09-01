package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 创建租户
 * @author: zsc
 * @create: 2020/8/24 3:54 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateTenantContent extends AbstractChanjetContent {
    private static final long serialVersionUID = 429452232312789726L;
    private String tenantId;
}
