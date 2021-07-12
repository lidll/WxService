package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName TextMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 09:57
 * @Version 1.0
 **/
@Data
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String,String > requestMap, String content){
        super(requestMap);
        //设置文本消息的msgType为text
        this.setMsgType("text");
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "content='" + content + '\'' +
                "} " + super.toString();
    }
}
