package com.chanjet.openapi.sdk.java.test;

import com.chanjet.openapi.sdk.java.ChanjetClient;
import com.chanjet.openapi.sdk.java.domain.CreateTenantContent;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.CreateTenantRequest;
import com.chanjet.openapi.sdk.java.response.CreateTenantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: zsc
 * @create: 2021/9/20 9:31 下午
 **/
@RequestMapping("test")
@RestController
public class TestController {
    @Autowired
    private ChanjetClient chanjetClient;

    /**
     * 创建租户
     *
     * @return
     */
    @GetMapping("createTenant")
    public CreateTenantResponse createTenant() throws ChanjetApiException {
        //创建租户
        CreateTenantRequest createTenantRequest = new CreateTenantRequest();
        CreateTenantContent createTenantContent = new CreateTenantContent();
        createTenantContent.setTenantId(UUID.randomUUID().toString());
        createTenantRequest.setBizContent(createTenantContent);
        CreateTenantResponse createTenantResponse = chanjetClient.execute(createTenantRequest);
        return createTenantResponse;
    }
}
