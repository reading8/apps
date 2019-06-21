package com.sxwl.apps.controller;
import com.google.gson.Gson;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
/**
 * @Description
 * @auther reading
 * @create 2019-06-07 19:37
 */
@Controller
public class test {
    @Autowired
    private WxMpService wxMpService;

    public String  aa(){
        System.out.println("authorize");
        //配置调用
        String url="http://xinoso.natapp1.cc/wb/userInfo";
        String redirectUrl= wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        System.out.println(redirectUrl);
        return "redirect:"+redirectUrl;
    }
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code) {
        System.out.println("执行了");
        WxMpUser wxMpUser = null;
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
             wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        System.out.println("有用户登陆了--------"+wxMpUser.getHeadImgUrl());
        Gson gson=new Gson();
        String s = gson.toJson(wxMpUser);
        System.out.println(s+"***************");
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("ohCGWwQHCap1n8H5DuGs6OZQz7cc")
                .templateId("7InrMGV1BPD0UPHJQEz07kNTAv8ZC7oeEMDweEU_QfQ")
                .url("http://www.baidu.com")
                .build();
        templateMessage.addData(new WxMpTemplateData("first", "你好，你在我们平台发布的消息有人留言了", "black"));
        templateMessage.addData(new WxMpTemplateData("keyword1", "58展业最新消息", "black"));
        templateMessage.addData(new WxMpTemplateData("keyword2", "留言消息处理", "black"));
        templateMessage.addData(new WxMpTemplateData("keyword3", "来自9755的账号给你留言了", "black"));
        templateMessage.addData(new WxMpTemplateData("remark", "点击这里查看留言内容", "black"));

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        System.out.println("执行了");
        return s;
    }
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("你好啊");
        return "index";
    }
}
