package com.sxwl.apps.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//全局属性配置
@Data
@Component
@ConfigurationProperties(prefix="apps")
public class Apps {
    private String loginUrl;
}
