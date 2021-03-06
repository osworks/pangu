package com.github.osworks.pangu.common.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

/**
 * pangu app environment handler
 * 
 * @author xiongchun
 * @since 4.0.0
 */
@Component
public class EnvironmentHandler {
    
    @Autowired
    private ConfigurableEnvironment configurableEnvironment;
    
    //"defaultProperties" is the default name
    public static final String DEFAULT_NAME = "defaultProperties";
    
    public void setDefaultConfigurations() {
        MutablePropertySources mps = configurableEnvironment.getPropertySources();
        Properties p = new Properties();
        p.put("powered-by", "PanGu Microservice Framework");
        mps.addFirst(new PropertiesPropertySource("defaultProperties", p));
    }
}
