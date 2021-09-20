package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 获取企业凭证
 *
 * @author: zsc
 * @create: 2020/11/5 4:05 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetOrgAccessTokenContent extends AbstractChanjetContent {
    /**
     * 应用凭证
     */
    private String appAccessToken;
    /**
     * 企业永久授权码
     */
    private String permanentAuthCode;
}
