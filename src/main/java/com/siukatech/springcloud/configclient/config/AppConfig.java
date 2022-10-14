package com.siukatech.springcloud.configclient.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
//@ConfigurationProperties("app")
public class AppConfig {

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    @Value("${app.local.prop.value:-}")
    private String localPropValue;

    @Value("${app.server.prop.value:-}")
    private String serverPropValue;

    @Value("${app.common.prop.value:-}")
    private String commonPropValue;

}
