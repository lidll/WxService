package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName VoiceMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 10:55
 * @Version 1.0
 **/
@Data
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;

    public VoiceMessage(Map<String,String > requestMap, String mediaId){
        super(requestMap);
        //设置文本消息的msgType为text
        this.setMsgType("voice");
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "VoiceMessage{" +
                "mediaId='" + mediaId + '\'' +
                "} " + super.toString();
    }
}
