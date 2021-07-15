package com.yz.utils;

import com.yz.constant.EatWhatCon;

import java.util.Random;

/**
 * @ClassName EatWhatUtil
 * @Description TODO
 * @Author noah
 * @Date 2021/7/14 14:55
 * @Version 1.0
 **/
public class EatWhatTemplateUtil {


    /**
     *
     * @Author yz
     * @Description 拼接吃什么的回复,更加自然
     * @Date 2021/7/14 14:57
      * @param content
     * @return java.lang.String
     */
    public static String formatAnswer(String content){
        Random random = new Random();
        int i = random.nextInt(EatWhatCon.EAT_WHAT_TEMPLATES.length);
        return String.format(EatWhatCon.EAT_WHAT_TEMPLATES[i],content);
    }
}
