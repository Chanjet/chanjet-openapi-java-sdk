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
    private BigDecimal balanceAmount;
    /**
     * 科目ID
     */
    private String glAccountId;
    /**
     * 外部单号
     */
    private String externalCode;
    /**
     * 财务账号
     */
    private String finAccountNo;

}
