package com.yz.service.impl;

import com.yz.factory.TextAnswerFactory;
import com.yz.strategy.TextAnswerStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName TestAnswerService
 * @Description 普通消息service
 * @Author noah
 * @Date 2021/11/4 14:19
 * @Version 1.0
 **/
@Service
public class TextAnswerService {

    @Autowired
    private TextAnswerFactory textAnswerFactory;

    public String resolve(String content){
        //从工厂拿对应的处理策略
        TextAnswerStrategy strategy = textAnswerFactory.getStrategy(content);
        if (Objects.isNull(strategy)) {
            throw new RuntimeException("文本消息未找到处理策略!!!!!!!!!!");
        }
        return strategy.getAnswer(content);
    }
}
