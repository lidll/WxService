package com.yz.enums;

import com.yz.strategy.DishStrategy;
import lombok.AllArgsConstructor;

/**
 * @ClassName CommandEnums
 * @Description TODO
 * @Author noah
 * @Date 2021/11/3 15:47
 * @Version 1.0
 **/
@AllArgsConstructor
public enum CommandEnum {

    service_dish("dish","菜谱","dishStrategy", DishStrategy.class);


    private String serviceName;
    private String desc;
    private String strategyName;
    private Class entity;

    public String getStrategyName(String serviceName){
        for (CommandEnum value : CommandEnum.values()) {
            if (value.serviceName.equals(serviceName)) {
                return value.strategyName;
            }
        }
        return null;
    }
}
