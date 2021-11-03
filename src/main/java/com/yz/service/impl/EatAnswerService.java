package com.yz.service.impl;

import com.yz.constant.RedisKeyCon;
import com.yz.utils.EatWhatTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName EatAnswerService
 * @Description "吃什么"的处理类
 * @Author noah
 * @Date 2021/7/12 17:20
 * @Version 1.0
 **/
@Service
public class EatAnswerService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String resolve(String content){
        String dishName = redisTemplate.opsForSet().randomMember(RedisKeyCon.DISH_SERVICE_REDIS_KEY);
        return EatWhatTemplateUtil.formatAnswer(dishName);
    }
}
