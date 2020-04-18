package com.github.osworks.pangu.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.github.osworks.pangu.common.log.LogLevelHandler;

/**
 * nacos main configuration listener
 * 
 * @author xiongchun
 * @since 4.0.0
 */
@Component
public class MainConfigListener {

    @Autowired
    private LogLevelHandler logLevelHandler;

    @NacosConfigListener(dataId = "${nacos.config.data-id}", timeout = 5000)
    public void onChange(String newCfgText) throws Exception {
        logLevelHandler.refreshLogLevel(newCfgText);
    }
    
}
