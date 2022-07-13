package com.yz.enums;

import com.yz.strategy.impl.BotAnswerStrategy;
import com.yz.strategy.impl.EatAnswerStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName TextAnswerEnum
 * @Description TODO
 * @Author noah
 * @Date 2021/11/4 14:23
 * @Version 1.0
 **/
@AllArgsConstructor
@Getter
public enum TextAnswerEnum {
    EAT_ANSWER_STRATEGY("eat","吃什么策略","eatAnswerStrategy", EatAnswerStrategy.class),
    BOT_ANSWER_STRATEGY("bot","机器人回复策略","botAnswerStrategy",BotAnswerStrategy .class);


    private String serviceName;
    private String desc;
    private String strategyName;
    private Class entity;

    public String getStrategyName(String serviceName){
        for (TextAnswerEnum value : TextAnswerEnum.values()) {
            if (value.serviceName.equals(serviceName)) {
                return value.strategyName;
            }
        }
        return null;
    }

}
