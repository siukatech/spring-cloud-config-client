package com.siukatech.springcloud.configclient.ui.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfigInfo {
    private String profile;
    private String local;
    private String server;
    private String common;
}