package com.yz.wxEntity.button;

import lombok.Data;

/**
 * @ClassName 小程序按钮
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 10:01
 * @Version 1.0
 **/
@Data
public class ProgramButton extends AbstractButon{
     private String type = "miniprogram";

     private String url;
     private String appid;
     private String pagepath;

    public ProgramButton(String name,String url,String appid,String pagepath) {
        super(name);
    }
}
