package com.chanjet.openapi.sdk.java.response.hsy;

import com.chanjet.openapi.sdk.java.ChanjetResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取好生意账套列表响应
 *
 * @author: zsc
 * @create: 2020/11/11 1:02 下午
 **/
public class FindByEnterpriseIdResponse extends ArrayList<FindByEnterpriseIdResponse.Param> implements ChanjetResponse {

    public static class Param {
        /**
         * 是否为默认账套
         */
        private Boolean isDefault;
        /**
         * 账套列表
         */
        private List<Tenant> tenant;

        public Boolean getDefault() {
            return isDefault;
        }

        public void setDefault(Boolean aDefault) {
            isDefault = aDefault;
        }

        public List<Tenant> getTenant() {
            return tenant;
        }

        public void setTenant(List<Tenant> tenant) {
            this.tenant = tenant;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "isDefault=" + isDefault +
                    ", tenant=" + tenant +
                    '}';
        }
    }

    public static class Tenant {
        /**
         * 账套ID
         */
        private Long id;
        /**
         * 账套名称
         */
        private String name;
        /**
         * 企业ID
         */
        private String enterpriseId;
        /**
         * 账套状态
         */
        private String statusEnum;
        /**
         * 创建时间
         */
        private String createdStamp;
        /**
         * 备注
         */
        private String comments;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getStatusEnum() {
            return statusEnum;
        }

        public void setStatusEnum(String statusEnum) {
            this.statusEnum = statusEnum;
        }

        public String getCreatedStamp() {
            return createdStamp;
        }

        public void setCreatedStamp(String createdStamp) {
            this.createdStamp = createdStamp;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        @Override
        public String toString() {
            return "Tenant{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", enterpriseId='" + enterpriseId + '\'' +
                    ", statusEnum='" + statusEnum + '\'' +
                    ", createdStamp='" + createdStamp + '\'' +
                    ", comments='" + comments + '\'' +
                    '}';
        }
    }
}
