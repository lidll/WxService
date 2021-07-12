package com.yz.wxEntity.button;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubButton
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 10:05
 * @Version 1.0
 **/
@Data
public class SubButton extends AbstractButon{
    private List<AbstractButon> sub_button = new ArrayList<>();
    public SubButton(String name) {
        super(name);
    }

    public SubButton(String name, List<AbstractButon> sub_button) {
        super(name);
        this.sub_button = sub_button;
    }
}
