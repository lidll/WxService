package com.yz.utils;

import com.yz.domain.entity.CommandEntity;

/**
 * @ClassName EntityUtil
 * @Description TODO
 * @Author noah
 * @Date 2021/7/14 22:33
 * @Version 1.0
 **/
public class EntityUtil {

    public static CommandEntity commandEntity(String content){
        CommandEntity commandEntity = new CommandEntity();
        if (content == null || content.length() == 0) {
            return null;
        }
        String[] contentArray = content.split(":");
        if (contentArray.length == 0 || contentArray.length == 1) {
            return null;
        }
        if (contentArray.length >=2) {
            commandEntity.setService(contentArray[1]);
        }
        if (contentArray.length >=3) {
            commandEntity.setMethod(contentArray[2]);
        }
        if (contentArray.length >=4) {
            commandEntity.setValue(contentArray[3]);
        }
        return commandEntity;
    }
}
