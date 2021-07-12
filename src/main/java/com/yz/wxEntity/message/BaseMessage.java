package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @ClassName BaseMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 09:54
 * @Version 1.0
 **/
@Data
@ToString
public class BaseMessage {
    //接收方
    @XStreamAlias("ToUserName")
    private String toUserName;
    //发送方
    @XStreamAlias("FromUserName")
    private String fromUserName;
    //创建时间
    @XStreamAlias("CreateTime")
    private String createTime;
    //消息类型
    @XStreamAlias("MsgType")
    private String msgType;

    public BaseMessage(Map<String,String > requestMap){
        this.toUserName = requestMap.get("FromUserName");
        this.fromUserName = requestMap.get("ToUserName");
        this.createTime = System.currentTimeMillis()/1000 +"";
    }
}
