package com.yz.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName EatAnswerService
 * @Description TODO
 * @Author noah
 * @Date 2021/7/12 17:20
 * @Version 1.0
 **/
@Service
public class EatAnswerService {


    public String resolve(String content){
        if (!content.contains("吃什么")) {
            return null;
        }
        return null;
    }
}
