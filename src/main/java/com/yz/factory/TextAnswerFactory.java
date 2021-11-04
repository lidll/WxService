package com.yz.factory;

import com.yz.constant.TextMsgKeyWordCon;
import com.yz.enums.TextAnswerEnum;
import com.yz.strategy.CommandStrategy;
import com.yz.strategy.TextAnswerStrategy;
import com.yz.utils.ChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @ClassName CommandFactory
 * @Description 消息回复类工厂
 * @Author noah
 * @Date 2021/11/3 15:29
 * @Version 1.0
 **/
@Service
public class TextAnswerFactory {

    @Autowired
    private Map<String, TextAnswerStrategy> textAnswerStrategyMap = new ConcurrentHashMap<>();

    public TextAnswerStrategy getStrategy(String content){
        TextAnswerStrategy strategy = null;

        if (TextMsgKeyWordCon.containsEatWhat(content)) {
            strategy = textAnswerStrategyMap.get(TextAnswerEnum.EAT_ANSWER_STRATEGY.getStrategyName());
        } else {
            //普通聊天从问答机器人获取回复
            strategy = textAnswerStrategyMap.get(TextAnswerEnum.BOT_ANSWER_STRATEGY.getStrategyName());
        }
        return strategy;
    }
}
