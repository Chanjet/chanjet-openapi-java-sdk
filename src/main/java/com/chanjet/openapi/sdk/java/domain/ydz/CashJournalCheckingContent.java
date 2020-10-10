package com.chanjet.openapi.sdk.java.domain.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

import java.math.BigDecimal;

/**
 * 易代账对账接口业务参数
 *
 * @author zsc
 * @create 2020/10/10 11:17 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CashJournalCheckingContent extends AbstractChanjetContent {
    /**
     * 参数
     */
    private Param param;

    public static class Param {
        /**
         * 条数
         */
        private Long count;
        /**
         * 业务日期
         */
        private String bizDate;
        /**
         * 收入金额
         */
        private BigDecimal receiptAmount;
        /**
         * 支出金额
         */
        private BigDecimal disbursementAmount;
        /**
         * 余额
         */
        private BigDecimal balance;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
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

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "count=" + count +
                    ", bizDate='" + bizDate + '\'' +
                    ", receiptAmount=" + receiptAmount +
                    ", disbursementAmount=" + disbursementAmount +
                    ", balance=" + balance +
                    '}';
        }
    }
}
