package com.github.osworks.pangu.common.boot.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.github.osworks.pangu.common.config.EnvironmentHandler;
import com.github.osworks.pangu.common.log.LogLevelHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Default PanguApp StartedEventListener
 * 
 * @author xiongchun
 * @since 4.0.0
 */
@Slf4j
@Component
public class DefaultAppStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{
    
    @Autowired
    private LogLevelHandler logLevelHandler;
    @Autowired
    private EnvironmentHandler environmentHandler;
    
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        logLevelHandler.initLogLevelWhenSartup();
        environmentHandler.setDefaultConfigurations();
        log.info(":: PanGu Microservice Framework Started");
    }


}
