package com.yz.wxEntity.button;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Button
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 09:52
 * @Version 1.0
 **/
@Data
public class Button {
    private List<AbstractButon> button = new ArrayList<>();
}
