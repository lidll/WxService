package com.yz.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName EatAnswerService
 * @Description TODO
 * @Author noah
 * @Date 2021/7/12 17:20
 * @Version 1.0
 **/
@Service
public class EatAnswerService {


    String[] dishMenu = {"炒菜","泡面","拉面","擂饭","饺子","羊肉粉"};


    public String resolve(String content){
        if (content.contains("吃什么")) {
            Random random = new Random();
            int i = random.nextInt(dishMenu.length);
            return dishMenu[i-1];
        }
        return null;
    }
}
