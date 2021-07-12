package com.yz.utils;

import com.alibaba.fastjson.JSON;
import com.yz.constant.WxCon;
import com.yz.wxEntity.button.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName 创建菜单
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 10:42
 * @Version 1.0
 **/
@Slf4j
public class MenuUtil {

    @Autowired
    TokenUtil tokenUtil;

    public String initMenu(){
        //创建菜单
        Button button = new Button();
        //第一个一级菜单
        button.getButton().add(new ClickButton("第一个菜单","1"));
        //第二个一级菜单
        button.getButton().add(new ViewButton("第二个菜单","http://www.baidu.com"));
        //第三个一级菜单
        SubButton subButton = new SubButton("实用功能");
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图识字", WxCon.PIC_TO_TEXT_FLAG));
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图审核", WxCon.PIC_CHECK));
        subButton.getSub_button().add(new ViewButton("网易新闻","http://news.163.com"));
        button.getButton().add(subButton);

        String requestData = JSON.toJSONString(button);
        log.info(requestData);
        //String data = "{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"miniprogram\",\"name\":\"wxa\",\"url\":\"http://mp.weixin.qq.com\",\"appid\":\"wx286b93c14bbf93aa\",\"pagepath\":\"pages/lunar/index\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";
        //准备url
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", tokenUtil.getAccessToken());
        log.info("请求url:" + url);
        String result = HttpRequestUtil.post(url, requestData);
        log.info(result);
        return result;

    }
}
