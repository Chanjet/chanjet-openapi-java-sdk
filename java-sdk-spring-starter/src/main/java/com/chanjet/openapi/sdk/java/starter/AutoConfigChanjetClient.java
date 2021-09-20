package com.chanjet.openapi.sdk.java.starter;

import com.chanjet.openapi.sdk.java.ChanjetClient;
import com.chanjet.openapi.sdk.java.DefaultChanjetClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zsc
 * @create: 2021/9/20 8:47 下午
 **/
@Configuration
@EnableConfigurationProperties(ChanjetSdkConfigProperties.class)
@ConditionalOnClass(DefaultChanjetClient.class)
public class AutoConfigChanjetClient {

    /**
     * 初始化chanjetClient Bean
     *
     * @return
     */
    @ConditionalOnMissingBean
    @Bean
    public ChanjetClient chanjetClient(ChanjetSdkConfigProperties config) {
        return new DefaultChanjetClient(config.getServerUrl(), config.getAppKey(), config.getAppSecret(),
                config.getConnectTimeout(), config.getReadTimeout(), config.getKeepAliveTimeout(), config.getSignKey());
    }
}
