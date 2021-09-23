package com.chanjet.openapi.sdk.java;

import com.chanjet.openapi.sdk.java.domain.CreateTenantContent;
import com.chanjet.openapi.sdk.java.domain.GetTenantTokenContent;
import com.chanjet.openapi.sdk.java.domain.TrailProductContent;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.CreateTenantRequest;
import com.chanjet.openapi.sdk.java.request.GetTenantTokenRequest;
import com.chanjet.openapi.sdk.java.request.TrailProductRequest;
import com.chanjet.openapi.sdk.java.response.CreateTenantResponse;
import com.chanjet.openapi.sdk.java.response.GetTenantTokenResponse;
import com.chanjet.openapi.sdk.java.response.TrailProductResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.UUID;

/**
 * @author: zsc
 * @create: 2021/9/9 4:52 下午
 **/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DefaultClientTest {
    private static final String APP_KEY = "hdxtXDas";
    private static final String APP_SECRET = "10FBDBD5C316ABD58E29BC488B723C91";
    private static String tenantId;
    private static ChanjetClient chanjetClient;

    @BeforeClass
    public static void init() {
        chanjetClient = new DefaultChanjetClient("https://openapi.inte.chanjet.com", APP_KEY, APP_SECRET);
        tenantId = UUID.randomUUID().toString();
    }

    @Test
    public void test01CreateTenantRequestTest() throws ChanjetApiException {
        //创建租户
        CreateTenantRequest createTenantRequest = new CreateTenantRequest();
        CreateTenantContent createTenantContent = new CreateTenantContent();
        createTenantContent.setTenantId(tenantId);
        createTenantRequest.setAppKey(APP_KEY);
        createTenantRequest.setAppSecret(APP_SECRET);
        createTenantRequest.setRequestUri("/financial/orgAndUser/createTenant");
        createTenantRequest.setBizContent(createTenantContent);
        CreateTenantResponse createTenantResponse = chanjetClient.execute(createTenantRequest);
        //断言是否请求正确
        Assert.assertTrue(createTenantResponse.getResult());
    }


    @Test
    public void test02TrailProductRequestTest() throws ChanjetApiException {
        //产品试用测试
        TrailProductRequest trailProductRequest = new TrailProductRequest();
        TrailProductContent trailProductContent = new TrailProductContent();
        trailProductContent.setProductId("59");
        trailProductContent.setTenantId(tenantId);
        trailProductContent.setAgentCode("open");
        trailProductRequest.setAppKey(APP_KEY);
        trailProductRequest.setAppSecret(APP_SECRET);
        trailProductRequest.setBizContent(trailProductContent);
        trailProductRequest.setRequestUri("/financial/order/trailProduct");
        TrailProductResponse trailProductResponse = chanjetClient.execute(trailProductRequest);
        Assert.assertTrue(trailProductResponse.getResult());
    }


    @Test
    public void test03GetTenantTokenRequestTest() throws ChanjetApiException {
        //获取租户token
        GetTenantTokenRequest getTenantTokenRequest = new GetTenantTokenRequest();
        GetTenantTokenContent getTenantTokenContent = new GetTenantTokenContent();
        getTenantTokenContent.setScope("auth_all");
        getTenantTokenContent.setAppName("accounting");
        getTenantTokenContent.setTenantId(tenantId);
        getTenantTokenRequest.setBizContent(getTenantTokenContent);
        getTenantTokenRequest.setAppKey(APP_KEY);
        getTenantTokenRequest.setAppSecret(APP_SECRET);
        getTenantTokenRequest.setRequestUri("/financial/auth/getTenantToken");
        GetTenantTokenResponse getTenantTokenResponse = chanjetClient.execute(getTenantTokenRequest);
        Assert.assertTrue(getTenantTokenResponse.getResult());
    }
}
