package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName VideoMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 10:56
 * @Version 1.0
 **/
@Data
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    public VideoMessage(Map<String,String > requestMap, String mediaId,String title,String description){
        super(requestMap);
        //设置文本消息的msgType为text
        this.setMsgType("video");
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "VideoMessage{" +
                "mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
