package com.yz.service.impl;

import com.thoughtworks.xstream.XStream;
import com.yz.domain.DO.UserInfoDO;
import com.yz.service.UserInfoService;
import com.yz.utils.ListUtil;
import com.yz.wxEntity.message.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName WxService
 * @Description 微信消息处理service
 * @Author noah
 * @Date 2019-08-23 11:40
 * @Version 1.0
 **/
@Service
@Slf4j
public class WxService {

    @Autowired
    private DealMsgService dealMsgService;

    @Autowired
    private DealEventService dealEventService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param requestMap
     * @return java.lang.String
     * @Author yz
     * @Description map转换成xml数据包字符串 回复处理
     * @Date 2019-08-23 17:57
     */
    public String getResponse(Map<String, String> requestMap) {
        //处理用户
        String openId = requestMap.get("FromUserName");
        List<UserInfoDO> userInfoDOList = userInfoService.getByOpenId(openId);
        if (ListUtil.isEmpty(userInfoDOList)) {
            userInfoService.save(new UserInfoDO(openId));
        }
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
                msg = dealEventService.dealEvent(requestMap);
        }
        if (msg == null) {
            return null;
        }
        log.info(msg.toString());
        //包消息对象处理为xml数据表
        return beanToXml(msg);
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
