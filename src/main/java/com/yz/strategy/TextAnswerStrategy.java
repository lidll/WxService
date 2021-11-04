package com.yz.strategy;

/**
 * @ClassName TextAnswer
 * @Description TODO
 * @Author noah
 * @Date 2021/11/4 14:14
 * @Version 1.0
 **/
public interface TextAnswerStrategy {

    /**
     *
     * @Author yz
     * @Description 获取答复消息
     * @Date 2021/11/4 14:15
     * @param content
     * @return java.lang.String
     */
    String getAnswer(String content);
}
