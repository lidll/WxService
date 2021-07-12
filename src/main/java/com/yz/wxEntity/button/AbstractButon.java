package com.yz.wxEntity.button;

import lombok.Data;

/**
 * @ClassName AbstractButon
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 09:53
 * @Version 1.0
 **/
@Data
public abstract class AbstractButon {
    private String name;

    public AbstractButon(String name){
        this.name = name;
    }
}
