package com.chanjet.openapi.sdk.java.domain.ydz;

import com.chanjet.openapi.sdk.java.ChanjetContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 易代账批量新增日记账业务参数
 *
 * @author zsc
 * @create 2020/10/10 11:18 上午
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CashJournalBatchAddContent extends ArrayList<CashJournalBatchAddContent.Param> implements ChanjetContent {
    private static final long serialVersionUID = 1L;

    public static class Param {
        private static final long serialVersionUID = 1L;
        /**
         * 科目id
         */
        private Long glAccountId;
        /**
         * 银行账号id
         */
        private Long finAccountId;
        /**
         * 摘要
         */
        private String comments;
        /**
         * 业务日期
         */
        private String bizDate;
        /**
         * 收入
         */
        private BigDecimal receiptAmount;
        /**
         * 支出
         */
        private BigDecimal disbursementAmount;
        /**
         * 对方户名
         */
        private String couterpartyAccountName;
        /**
         * 顺序号
         */
        private Integer sequenceNum;

        /**
         * 外部单号
         */
        private String externalCode;
        /**
         * 财务账号
         */
        private String finAccountNo;
        /**
         * 备注
         */
        private String remark;
        /**
         * 收支类型名称
         */
        private String incomeDisbursementName;
        /**
         * 电子回单url
         */
        private String digitalReceiptUrl;

        public Long getGlAccountId() {
            return glAccountId;
        }

        public void setGlAccountId(Long glAccountId) {
            this.glAccountId = glAccountId;
        }

        public Long getFinAccountId() {
            return finAccountId;
        }

        public void setFinAccountId(Long finAccountId) {
            this.finAccountId = finAccountId;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getBizDate() {
            return bizDate;
        }

        public void setBizDate(String bizDate) {
            this.bizDate = bizDate;
        }

        public BigDecimal getReceiptAmount() {
            return receiptAmount;
        }

        public void setReceiptAmount(BigDecimal receiptAmount) {
            this.receiptAmount = receiptAmount;
        }

        public BigDecimal getDisbursementAmount() {
            return disbursementAmount;
        }

        public void setDisbursementAmount(BigDecimal disbursementAmount) {
            this.disbursementAmount = disbursementAmount;
        }

        public String getCouterpartyAccountName() {
            return couterpartyAccountName;
        }

        public void setCouterpartyAccountName(String couterpartyAccountName) {
            this.couterpartyAccountName = couterpartyAccountName;
        }

        public Integer getSequenceNum() {
            return sequenceNum;
        }

        public void setSequenceNum(Integer sequenceNum) {
            this.sequenceNum = sequenceNum;
        }

        public String getExternalCode() {
            return externalCode;
        }

        public void setExternalCode(String externalCode) {
            this.externalCode = externalCode;
        }

        public String getFinAccountNo() {
            return finAccountNo;
        }

        public void setFinAccountNo(String finAccountNo) {
            this.finAccountNo = finAccountNo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getIncomeDisbursementName() {
            return incomeDisbursementName;
        }

        public void setIncomeDisbursementName(String incomeDisbursementName) {
            this.incomeDisbursementName = incomeDisbursementName;
        }

        public String getDigitalReceiptUrl() {
            return digitalReceiptUrl;
        }

        public void setDigitalReceiptUrl(String digitalReceiptUrl) {
            this.digitalReceiptUrl = digitalReceiptUrl;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "glAccountId=" + glAccountId +
                    ", finAccountId=" + finAccountId +
                    ", comments='" + comments + '\'' +
                    ", bizDate='" + bizDate + '\'' +
                    ", receiptAmount=" + receiptAmount +
                    ", disbursementAmount=" + disbursementAmount +
                    ", couterpartyAccountName='" + couterpartyAccountName + '\'' +
                    ", sequenceNum=" + sequenceNum +
                    ", externalCode='" + externalCode + '\'' +
                    ", finAccountNo='" + finAccountNo + '\'' +
                    ", remark='" + remark + '\'' +
                    ", incomeDisbursementName='" + incomeDisbursementName + '\'' +
                    ", digitalReceiptUrl='" + digitalReceiptUrl + '\'' +
                    '}';
        }
    }
}
