package com.yz.strategy.impl;

import com.yz.strategy.TextAnswerStrategy;
import com.yz.utils.ChatUtil;
import org.springframework.stereotype.Component;

/**
 * @ClassName BotAnswerStrategy
 * @Description 回复机器人处理类
 * @Author noah
 * @Date 2021/11/4 14:29
 * @Version 1.0
 **/
@Component
public class BotAnswerStrategy implements TextAnswerStrategy {
    /**
     * @param content
     * @return java.lang.String
     * @Author yz
     * @Description 获取答复消息
     * @Date 2021/11/4 14:15
     */
    @Override
    public String getAnswer(String content) {
        content = ChatUtil.getRequest(content).replace("{br}", "\n");
        // :p 替换自动回复主语
        content = content.replace("菲菲","虾虾")
                .replace("美女","靓仔")
                .replace("小美人","小可爱");
        return content;
    }
}
