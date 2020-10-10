package com.chanjet.openapi.sdk.java.response.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import lombok.*;

/**
 * 日记账对账
 * @author zsc
 * @create 2020/10/10 11:11 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CashJournalCheckingResponse extends AbstractChanjetResponse {
    private int Code;
    private String Msg;
}
