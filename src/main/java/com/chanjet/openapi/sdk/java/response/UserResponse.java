package com.chanjet.openapi.sdk.java.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import lombok.*;

/**
 * @author: zsc
 * @create: 2020/11/11 11:52 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponse extends AbstractChanjetResponse {
    /**
     * 是否成功
     */
    private Boolean result;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 企业ID
     */
    private String orgId;
    /**
     * 企业全称
     */
    private String orgFullName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 用户名
     */
    private String username;
    /**
     * 名称
     */
    private String name;
    /**
     * 头像
     */
    private String headPicture;
    /**
     * 默认企业
     */
    private String defaultOrganization;
}
