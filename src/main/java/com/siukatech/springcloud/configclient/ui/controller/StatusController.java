package com.siukatech.springcloud.configclient.ui.controller;

import com.siukatech.springcloud.configclient.config.AppConfig;
import com.siukatech.springcloud.configclient.ui.model.ConfigInfo;
import com.siukatech.springcloud.configclient.ui.model.StatusInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private Environment environment;

    @GetMapping("")
    public ResponseEntity<StatusInfo> checkStatus() {
        String statusMsg = null;
        statusMsg = String.format("appConfig - Local: %s, Server: %s, Common: %s"
                + "<br/>"
                + "environment - Local: %s, Server: %s, Common: %s"
                , appConfig.getLocalPropValue()
                , appConfig.getServerPropValue()
                , appConfig.getCommonPropValue()
                , environment.getProperty("app.local.prop.value")
                , environment.getProperty("app.server.prop.value")
                , environment.getProperty("app.common.prop.value")
        );
        StatusInfo statusInfo = new StatusInfo();
        ConfigInfo appConfigInfo = ConfigInfo.builder()
                .profile(appConfig.getSpringProfilesActive())
                .local(appConfig.getLocalPropValue())
                .server(appConfig.getServerPropValue())
                .common(appConfig.getCommonPropValue())
                .build();
        ConfigInfo envConfigInfo = ConfigInfo.builder()
                .profile(environment.getProperty("spring.profiles.active"))
                .local(environment.getProperty("app.local.prop.value"))
                .server(environment.getProperty("app.server.prop.value"))
                .common(environment.getProperty("app.common.prop.value"))
                .build();
        statusInfo.setAppConfigInfo(appConfigInfo);
        statusInfo.setEnvConfigInfo(envConfigInfo);
        return ResponseEntity.status(HttpStatus.OK).body(statusInfo);
    }

}
