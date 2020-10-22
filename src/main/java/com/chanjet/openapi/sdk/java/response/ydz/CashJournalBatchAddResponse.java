package com.chanjet.openapi.sdk.java.response.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 批量新增日记账
 *
 * @author zsc
 * @create 2020/10/10 11:10 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CashJournalBatchAddResponse extends AbstractChanjetResponse {
    private String code;
    private List<Param> data;
    private Boolean successful;

    public static class Param implements Serializable {
        private static final long serialVersionUID = 4153538724461132216L;
        private Long id;
        private String acctgPeriod;
        private String bizDate;
        private String cashJournalSrcEnum;
        private String comments;
        private String couterpartyAccountName;
        private Long dateType;
        private BigDecimal disbursementAmount;
        private Long finAccountId;
        private Long incomeDisbursementTypeId;
        private Boolean isBeginning;
        private String lastUpdatedStamp;
        private BigDecimal receiptAmount;
        private Long sequenceNum;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAcctgPeriod() {
            return acctgPeriod;
        }

        public void setAcctgPeriod(String acctgPeriod) {
            this.acctgPeriod = acctgPeriod;
        }

        public String getBizDate() {
            return bizDate;
        }

        public void setBizDate(String bizDate) {
            this.bizDate = bizDate;
        }

        public String getCashJournalSrcEnum() {
            return cashJournalSrcEnum;
        }

        public void setCashJournalSrcEnum(String cashJournalSrcEnum) {
            this.cashJournalSrcEnum = cashJournalSrcEnum;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getCouterpartyAccountName() {
            return couterpartyAccountName;
        }

        public void setCouterpartyAccountName(String couterpartyAccountName) {
            this.couterpartyAccountName = couterpartyAccountName;
        }

        public Long getDateType() {
            return dateType;
        }

        public void setDateType(Long dateType) {
            this.dateType = dateType;
        }

        public BigDecimal getDisbursementAmount() {
            return disbursementAmount;
        }

        public void setDisbursementAmount(BigDecimal disbursementAmount) {
            this.disbursementAmount = disbursementAmount;
        }

        public Long getFinAccountId() {
            return finAccountId;
        }

        public void setFinAccountId(Long finAccountId) {
            this.finAccountId = finAccountId;
        }

        public Long getIncomeDisbursementTypeId() {
            return incomeDisbursementTypeId;
        }

        public void setIncomeDisbursementTypeId(Long incomeDisbursementTypeId) {
            this.incomeDisbursementTypeId = incomeDisbursementTypeId;
        }

        public Boolean getBeginning() {
            return isBeginning;
        }

        public void setBeginning(Boolean beginning) {
            isBeginning = beginning;
        }

        public String getLastUpdatedStamp() {
            return lastUpdatedStamp;
        }

        public void setLastUpdatedStamp(String lastUpdatedStamp) {
            this.lastUpdatedStamp = lastUpdatedStamp;
        }

        public BigDecimal getReceiptAmount() {
            return receiptAmount;
        }

        public void setReceiptAmount(BigDecimal receiptAmount) {
            this.receiptAmount = receiptAmount;
        }

        public Long getSequenceNum() {
            return sequenceNum;
        }

        public void setSequenceNum(Long sequenceNum) {
            this.sequenceNum = sequenceNum;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "id=" + id +
                    ", acctgPeriod='" + acctgPeriod + '\'' +
                    ", bizDate='" + bizDate + '\'' +
                    ", cashJournalSrcEnum='" + cashJournalSrcEnum + '\'' +
                    ", comments='" + comments + '\'' +
                    ", couterpartyAccountName='" + couterpartyAccountName + '\'' +
                    ", dateType=" + dateType +
                    ", disbursementAmount=" + disbursementAmount +
                    ", finAccountId=" + finAccountId +
                    ", incomeDisbursementTypeId=" + incomeDisbursementTypeId +
                    ", isBeginning=" + isBeginning +
                    ", lastUpdatedStamp='" + lastUpdatedStamp + '\'' +
                    ", receiptAmount=" + receiptAmount +
                    ", sequenceNum=" + sequenceNum +
                    '}';
        }
    }
}
