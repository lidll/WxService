package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Article
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 11:20
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@XStreamAlias("item")
public class Article {

    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Url")
    private String url;

}
