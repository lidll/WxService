package com.yz.strategy.impl;

import com.yz.constant.RedisKeyCon;
import com.yz.strategy.TextAnswerStrategy;
import com.yz.utils.EatWhatTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName EatAnswerService
 * @Description "吃什么"的处理类
 * @Author noah
 * @Date 2021/7/12 17:20
 * @Version 1.0
 **/
@Component
public class EatAnswerStrategy implements TextAnswerStrategy {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getAnswer(String content){
        String dishName = redisTemplate.opsForSet().randomMember(RedisKeyCon.DISH_SERVICE_REDIS_KEY);
        return EatWhatTemplateUtil.formatAnswer(dishName);
    }
}
