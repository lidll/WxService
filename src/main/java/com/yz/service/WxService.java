package com.yz.service;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.yz.constant.WxCon;
import com.yz.wxEntity.*;
import com.yz.wxEntity.message.*;
import com.yz.utils.HttpRequestUtil;
import com.yz.utils.ChatUtil;
import com.yz.utils.PicAiUtil;
import com.yz.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

/**
 * @ClassName WxCheckService
 * @Description TODO
 * @Author noah
 * @Date 2019-08-23 11:40
 * @Version 1.0
 **/
@Service
@Slf4j
public class WxService {

    @Autowired
    private DealMsgService dealMsgService;

    /**
     * @param is
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @Author yz
     * @Description 解析xml为map
     * @Date 2019-08-23 17:55
     */
    public Map<String, String> parseRequest(InputStream is) {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流,获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取根节点
            Element rootElement = document.getRootElement();
            //获取根节点的所有子节点
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }
            return map;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param requestMap
     * @return java.lang.String
     * @Author yz
     * @Description map转换成xml数据包字符串 回复处理
     * @Date 2019-08-23 17:57
     */
    public String getResponse(Map<String, String> requestMap) {
        BaseMessage msg = null;
        String msgType = requestMap.get("MsgType");
        switch (msgType) {
            //文本消息
            case "text":
                msg = dealMsgService.dealText(requestMap);
                break;
            //图片消息
            case "image":
                msg = dealMsgService.dealImage(requestMap);
                break;
            //语音消息
            case "voice":
                break;
            //视频消息
            case "video":
                break;
            //音乐消息
            case "music":
                break;
            //图文消息
            case "news":
                break;
            case "event":
                msg = dealEvent(requestMap);
        }
        if (msg == null) {
            return null;
        }
        log.info(msg.toString());
        //包消息对象处理为xml数据表
        return beanToXml(msg);
    }



    /**
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     * @Author yz
     * @Description 事件处理
     * @Date 2019-08-27 11:28
     */
    private BaseMessage dealEvent(Map<String, String> requestMap) {
        String event = requestMap.get("Event");
        switch (event) {
            //取消关注
            case "unsubscribe":
                return EventService.dealUnsubscribe(requestMap);
            //关注
            case "subscribe":
                return EventService.dealSubscribe(requestMap);
            //点击按钮
            case "CLICK":
                //个人公众号开启开发者模式没有菜单
//                return EventService.dealClient(requestMap);
                return null;
            //跳转按钮
            case "VIEW":
                return EventService.dealView(requestMap);
                //图片事件
            case "pic_photo_or_album":
                return EventService.dealPic(requestMap);

            default:
                return null;
        }
    }

    /**
     * @param msg
     * @return void
     * @Author yz
     * @Description 包消息对象处理为xml数据表
     * @Date 2019-08-26 14:14
     */
    private String beanToXml(BaseMessage msg) {
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMessage.class);
        xStream.processAnnotations(ImageMessage.class);
        xStream.processAnnotations(MusicMessage.class);
        xStream.processAnnotations(NewsMessage.class);
        xStream.processAnnotations(VideoMessage.class);
        xStream.processAnnotations(VoiceMessage.class);
        return xStream.toXML(msg);
    }


}
