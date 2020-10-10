package com.chanjet.openapi.sdk.java.domain.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 易代账批量新增日记账业务参数
 * @author zsc
 * @create 2020/10/10 11:18 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CashJournalBatchAddContent extends AbstractChanjetContent {
    /**
     * 参数
     */
    private List<Param> param;

    public static class Param {
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
                    '}';
        }
    }
}
