package com.yz.wxEntity.button;

import lombok.Data;

/**
 * @ClassName 链接按钮
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 10:00
 * @Version 1.0
 **/
@Data
public class ViewButton extends AbstractButon{
    private String type = "view";
    private String url;

    public ViewButton(String name,String url) {
        super(name);
        this.url = url;
    }
}
