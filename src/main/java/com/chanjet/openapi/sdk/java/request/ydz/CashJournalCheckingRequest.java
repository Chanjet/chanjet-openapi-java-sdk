package com.chanjet.openapi.sdk.java.request.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.ydz.CashJournalCheckingResponse;

/**
 * 日记账对账
 * @author zsc
 * @create 2020/10/10 11:10 上午
 **/
public class CashJournalCheckingRequest extends AbstractChanjetRequest<CashJournalCheckingResponse> {
    @Override
    public Class<CashJournalCheckingResponse> getResponseClass() {
        return CashJournalCheckingResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
