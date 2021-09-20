package com.chanjet.openapi.sdk.java.response.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;
import lombok.*;

/**
 * 新增日记账
 *
 * @author zsc
 * @create 2020/10/10 11:10 上午
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CashJournalAddResponse extends AbstractChanjetResponse {
    private String code;
    private Long data;
    private Boolean successful;
}
