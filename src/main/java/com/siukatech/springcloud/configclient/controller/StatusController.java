package com.siukatech.springcloud.configclient.controller;

import com.siukatech.springcloud.configclient.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    public String checkStatus() {
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
        return statusMsg;
    }

}
