package com.yz.wxEntity.button;

import lombok.Data;

/**
 * @ClassName 普通按钮
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 09:58
 * @Version 1.0
 **/
@Data
public class ClickButton extends AbstractButon{

    private String type = "click";

    private String key;

    public ClickButton(String name,String key) {
        super(name);
        this.key = key;
    }
}
