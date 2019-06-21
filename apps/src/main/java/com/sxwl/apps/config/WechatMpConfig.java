package com.sxwl.apps.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther reading
 * @create 2019-05-02 21:55
 */
@Component
public class WechatMpConfig {
    @Autowired
    private WeChatAccountConfig weChatAccountConfig;
    @Bean
    public WxMpService wxMpService(){
        WxMpService  wxMpService=new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return  wxMpService;
    }
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage  wxMpConfigStoragess=new WxMpInMemoryConfigStorage();
        wxMpConfigStoragess.setAppId(weChatAccountConfig.getMpAppId());
        wxMpConfigStoragess.setSecret(weChatAccountConfig.getMpAppSecret());
        return  wxMpConfigStoragess;
    }
}
