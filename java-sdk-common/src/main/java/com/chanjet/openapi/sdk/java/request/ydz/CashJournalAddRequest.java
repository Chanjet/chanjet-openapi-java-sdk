package com.chanjet.openapi.sdk.java.request.ydz;

import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;
import com.chanjet.openapi.sdk.java.response.ydz.CashJournalAddResponse;

/**
 * 新增日记账
 * @author zsc
 * @create 2020/10/10 11:09 上午
 **/
public class CashJournalAddRequest extends AbstractChanjetRequest<CashJournalAddResponse> {
    @Override
    public Class<CashJournalAddResponse> getResponseClass() {
        return CashJournalAddResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
