//package com.yz.manager;
//
//import com.alibaba.fastjson.JSON;
//import com.google.common.collect.ImmutableMap;
//import com.yz.service.WxService;
//import com.yz.utils.HttpRequestUtil;
//import org.junit.jupiter.api.Test;
//
///**
// * @ClassName TemplateMessageManager
// * @Description 模板消息管理
// * @Author noah
// * @Date 2019-08-27 17:36
// * @Version 1.0
// **/
//public class TemplateMessageManager {
//
//    /**
//     *
//     * @Author yz
//     * @Description 设置行业
//     * @Date 2019-08-27 17:56
//     * @param
//     * @return void
//     */
//    public static void setIndustry(){
//        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + WxService.getAccessToken() ;
//        String data = "{\"industry_id1\":\"1\",\"industry_id2\":\"4\"}";
//        String result = HttpRequestUtil.post(url, data);
//        System.out.println(result);
//    }
//
//    /**
//     *
//     * @Author yz
//     * @Description 获取行业
//     * @Date 2019-08-27 18:02
//     * @param
//     * @return void
//     */
//    public static void getIndustry(){
//        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + WxService.getAccessToken();
//        String s = HttpRequestUtil.get(url);
//        System.out.println(s);
//    }
//
//    /**
//     *
//     * @Author yz
//     * @Description 获取模板id
//     * @Date 2019-08-27 18:03
//     * @param
//     * @return void
//     */
//    public static void getTemplateId(String templateIdShort){
//        String data = JSON.toJSONString(ImmutableMap.<String, String>builder().put("template_id_short", templateIdShort).build());
//        String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + WxService.getAccessToken();
//        String s = HttpRequestUtil.post(url,data);
//        System.out.println(s);
//    }
//
//
//}
