package com.siukatech.springcloud.configclient.ui.model;

import lombok.Data;

@Data
public class StatusInfo {
    private ConfigInfo appConfigInfo;
    private ConfigInfo envConfigInfo;
}
