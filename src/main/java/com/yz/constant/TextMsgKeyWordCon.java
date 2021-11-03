package com.yz.constant;

import javafx.beans.property.StringProperty;

/**
 * @ClassName SayKeyCon
 * @Description 消息关键字
 * @Author noah
 * @Date 2021/7/13 12:10
 * @Version 1.0
 **/
public class TextMsgKeyWordCon {

    public static final String[] EAT_WHAT ={
            "吃点什么",
            "吃什么",
            "吃啥",
    };

    public static boolean containsEatWhat(String content){
        for (String s : TextMsgKeyWordCon.EAT_WHAT) {
            if (content.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
