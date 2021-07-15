package com.yz.service.impl;

import com.yz.constant.KeyWordCon;
import com.yz.utils.EatWhatTemplateUtil;
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


    String[] dishMenu = {"炒菜","烫饭","泡面","拉面","擂饭","盖浇饭","饺子","羊肉粉","牛肉面","面包","黄焖鸡","喷射套餐","生烫"};


    public String resolve(String content){
        Random random = new Random();
        int i = random.nextInt(dishMenu.length);
        return EatWhatTemplateUtil.formatAnswer(dishMenu[i]);
    }
}
