package com.yz.domain.entity;

import lombok.Data;

/**
 * @ClassName CommEntity
 * @Description TODO
 * @Author noah
 * @Date 2021/7/14 22:33
 * @Version 1.0
 **/
@Data
public class CommandEntity {

    //服务
    private String service;
    //方法
    private String method;
    //参数
    private String value;
}
