package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName ImageMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 10:53
 * @Version 1.0
 **/
@Data
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;

    public ImageMessage(Map<String,String > requestMap, String mediaId){
        super(requestMap);
        //设置文本消息的msgType为text
        this.setMsgType("image");
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "ImageMessage{" +
                "mediaId='" + mediaId + '\'' +
                "} " + super.toString();
    }
}
