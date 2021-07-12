package com.yz.wxEntity.button;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PhotoOrAlbumButton
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 10:15
 * @Version 1.0
 **/
@Data
public class PhotoOrAlbumButton extends AbstractButon{
    private String type = "pic_photo_or_album";
    private String key;
    private List<AbstractButon> sub_button = new ArrayList<>();
    public PhotoOrAlbumButton(String name,String key) {
        super(name);
        this.key = key;
    }
}
