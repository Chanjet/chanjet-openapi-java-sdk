package com.chanjet.openapi.sdk.java.domain;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

/**
 * 根据用户永久授权码获取token
 *
 * @author: zsc
 * @create: 2020/11/5 4:05 下午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetTokenByPermanentCodeContent extends AbstractChanjetContent {
    /**
     * 企业凭证
     */
    private String orgAccessToken;
    /**
     * 用户永久授权码
     */
    private String userAuthPermanentCode;
}
