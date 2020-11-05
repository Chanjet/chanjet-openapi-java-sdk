package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 获取应用凭证
 *
 * @author: zsc
 * @create: 2020/11/5 4:01 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetAppAccessTokenContent extends AbstractChanjetContent {
    /**
     * 开放平台推送的appTicket
     */
    private String appTicket;
}
