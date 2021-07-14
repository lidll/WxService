package com.yz.service;

import com.yz.constant.WxCon;
import com.yz.utils.ChatUtil;
import com.yz.utils.PicAiUtil;
import com.yz.wxEntity.FlagArgument;
import com.yz.wxEntity.message.Article;
import com.yz.wxEntity.message.BaseMessage;
import com.yz.wxEntity.message.NewsMessage;
import com.yz.wxEntity.message.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * @ClassName DealMsgService
 * @Description 消息处理service
 * @Author noah
 * @Date 2021/7/12 17:22
 * @Version 1.0
 **/
@Service
@Slf4j
public class DealMsgService {

    @Autowired
    EatAnswerService eatAnswerService;

    /**
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     * @Author yz
     * @Description 处理文本消息
     * @Date 2019-08-26 10:10
     */
    public BaseMessage dealText(Map<String, String> requestMap) {
        log.info("dealText Service ~~~~~~~~~~~~~~" + requestMap.toString());
        //用户发来的消息内容
        String content = requestMap.get("Content");

        if (content.equals("图文")) {
            ArrayList<Article> article = new ArrayList<>();
            article.add(new Article("这是一个图文消息", "这是图文消息的描述", "", "http://www.baidu.com"));
            return new NewsMessage(requestMap, article);
        }
        String answer = "我有点糊涂了~~ (´･_･`)";
        if (content.contains("吃什么")) {
            answer = eatAnswerService.resolve(content);
        } else {
            //普通聊天从问答机器人获取回复
            answer = ChatUtil.getRequest(content, requestMap.get("FromUserName")).replace("{br}", "\n");
        }
        return new TextMessage(requestMap, answer);
    }

    /**
     *
     * @Author yz
     * @Description 处理图片消息
     * @Date 2019-08-27 14:56
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     */
    public BaseMessage dealImage(Map<String, String> requestMap) {

        String flag = FlagArgument.getFlag();
        System.out.println(FlagArgument.getFlag());
        //如果图片审核
        if (WxCon.PIC_CHECK.equals(flag)) {
            String picUrl = PicAiUtil.checkPic(requestMap.get("PicUrl"));
            FlagArgument.reset();
            return new TextMessage(requestMap,picUrl);
        }else if (WxCon.PIC_TO_TEXT_FLAG.equals(flag)){
            String picText = PicAiUtil.getPicText(requestMap.get("PicUrl"));
            FlagArgument.reset();
            return new TextMessage(requestMap,picText);
        }else{
            return new TextMessage(requestMap,"请先在<更多功能>中选择图片功能");
        }

    }
}
