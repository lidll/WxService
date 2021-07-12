package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName MusicMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 11:00
 * @Version 1.0
 **/
@Data
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {

    @XStreamAlias("Music")
    private Music music;

    public MusicMessage(Map<String,String > requestMap,
                        String title,
                        String description,
                        String musicURL,
                        String hqMusicUrl,
                        String thumbMediaId
                        ){
        super(requestMap);
        this.setMsgType("music");
        //设置文本消息的msgType为text
        this.music = new Music(title,description,musicURL,hqMusicUrl,thumbMediaId);
    }
}
