package com.sxwl.apps.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther reading
 * @create 2019-05-02 22:29
 */
@Data
@Component
@ConfigurationProperties(prefix="wechat")
public class WeChatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;
    /** 商户号 */
    private String mchId;
    /** 商户密钥 */
    private String mchKey;
    /** 商户证书路径 */
    private String keyPath;
    /** 微信异步通知地址 */
    private String notifyUrl;
}
