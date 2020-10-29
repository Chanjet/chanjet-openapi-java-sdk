package com.chanjet.openapi.sdk.java.domain.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetContent;
import lombok.*;

import java.math.BigDecimal;

/**
 * 易代账新增日记账业务参数
 *
 * @author zsc
 * @create 2020/10/10 11:18 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CashJournalAddContent extends AbstractChanjetContent {
    /**
     * 科目id
     */
    private Long glAccountId;
    /**
     * 财务账号
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
     * 收入，收入和支出金额填一个即可，另外一项填0
     */
    private BigDecimal receiptAmount;
    /**
     * 支出，收入和支出金额填一个即可，另外一项填0
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
}
