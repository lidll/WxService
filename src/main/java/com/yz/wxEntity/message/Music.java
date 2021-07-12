package com.yz.wxEntity.message;

import lombok.Data;

/**
 * @ClassName Music
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 11:11
 * @Version 1.0
 **/
@Data
public class Music {
    private String title;
    private String description;
    private String musicURL;
    private String hqMusicUrl;
    private String thumbMediaId;

    public Music(String title,
                  String description,
                  String musicURL,
                  String hqMusicUrl,
                  String thumbMediaId){
        this.title = title;
        this.description = description;
        this.musicURL = musicURL;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }
}
