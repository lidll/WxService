package com.yz;

import com.alibaba.fastjson.JSON;
import com.sun.javaws.jnl.XMLFormat;
import com.thoughtworks.xstream.XStream;
import com.yz.utils.HttpRequestUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestWxPay
 * @Description TODO
 * @Author noah
 * @Date 2019-09-26 16:59
 * @Version 1.0
 **/
public class TestWxPay {
    public static final String PayUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    @Test
    public void test(){
        Map<String, Object> map = new HashMap<>();
        //一办appid
        map.put("appid","wx5c77b4866fc0a3e7");
        //商户号
        map.put("mch_id","1556556871");
        //随机码
        map.put("nonce_str","5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        //签名
        map.put("sign","C380BEC2BFD727A4B6845133519F3AD6");
        //商品描述
        map.put("body","评议saas服务管理平台-购买参评单位订单");
        //商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
        map.put("out_trade_no","EN123123123123");
        //订单总金额，单位为分
        map.put("total_fee","100");
        //支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
        map.put("spbill_create_ip","111.172.196.52");
        //异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        map.put("notify_url","http://lifeidll.free.idcfengye.com/callback/success");
        //付款类型
        map.put("trade_type","NATIVE");
        map.put("product_id","123123");

        XStream xStream = new XStream();
        xStream.processAnnotations(Map.class);
        String s = xStream.toXML(map);
        String post = HttpRequestUtil.post(PayUrl, s);
        System.out.println(post);
    }

}
