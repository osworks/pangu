package com.github.osworks.pangu.common.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.github.osworks.pangu.common.log.LogLevelHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * PanguApp StartedEventListener
 * 
 * @author xiongchun
 * @since 4.0.0
 */
@Slf4j
@Component
public class PanguAppStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{
    
    @Autowired
    private LogLevelHandler logLevelHandler;
    
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        logLevelHandler.getConfigAndRefreshLogLevel();
        log.info("PanGu Microservice Framework ---- OK");
    }


}
