package com.yz.wxEntity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName NewsMessage
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 11:03
 * @Version 1.0
 **/
@Data
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {

    @XStreamAlias("ArticleCount")
    private String articleCount;

    @XStreamAlias("Articles")
    private List<Article> articles ;

    public NewsMessage(Map<String,String > requestMap,
                       List<Article> articles){
        super(requestMap);
        this.setMsgType("news");
        this.articleCount = articles.size() + "";
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsMessage{" +
                "articleCount='" + articleCount + '\'' +
                ", articles=" + articles +
                "} " + super.toString();
    }
}
