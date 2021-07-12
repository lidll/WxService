package com.yz.service;

import com.yz.constant.WxCon;
import com.yz.wxEntity.FlagArgument;
import com.yz.wxEntity.message.BaseMessage;
import com.yz.wxEntity.message.TextMessage;

import java.util.Map;

/**
 * @ClassName EventService
 * @Description 处理event事件service
 * @Author noah
 * @Date 2019-08-27 14:06
 * @Version 1.0
 **/
public class EventService {

    /**
     *
     * @Author yz
     * @Description 关注事件
     * @Date 2019-08-27 14:09
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     */
    public static BaseMessage dealSubscribe(Map<String,String> requestMap){
        return new TextMessage(requestMap,"欢迎关注本公众号!\n可以开始欢乐的聊天啦!我现在还很弱小,只能陪你随便聊聊~");
    }
    /**
     *
     * @Author yz
     * @Description 取关事件
     * @Date 2019-08-27 14:10
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     */
    public static BaseMessage dealUnsubscribe(Map<String,String> requestMap){
        return null;
    }

//    /**
//     *
//     * @Author yz
//     * @Description 点击事件
//     * @Date 2019-08-27 14:09
//     * @param requestMap
//     * @return com.yz.wxEntity.message.BaseMessage
//     */
//    public static BaseMessage dealClient(Map<String,String> requestMap){
//        String eventKey = requestMap.get("EventKey");
//        switch (eventKey) {
//            //点击第一个一级菜单
//            case "1":
//                return new TextMessage(requestMap,"点击第一个一级菜单");
//            //处理点击第三个一级菜单
//            case "31":
//                return new TextMessage(requestMap,"点了一下第三个一级菜单");
//            //处理点击第三个二级菜单
//            case "32":
//                return new TextMessage(requestMap,"处理点击第三个二级菜单");
//        }
//        return null;
//    }

    /**
     *
     * @Author yz
     * @Description 链接事件
     * @Date 2019-08-27 14:09
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     */
    public static BaseMessage dealView(Map<String,String> requestMap){
        return null;
    }

    /**
     *
     * @Author yz
     * @Description 修改图片处理标识,便于图片上传后对应指定功能
     * @Date 2019-08-27 16:44
     * @param requestMap
     * @return com.yz.wxEntity.message.BaseMessage
     */
    public static BaseMessage dealPic(Map<String,String> requestMap){
        String eventKey = requestMap.get("EventKey");
        switch (eventKey) {
            //图片审核
            case WxCon.PIC_CHECK:
                FlagArgument.setFlag(WxCon.PIC_CHECK);
                System.out.println(FlagArgument.getFlag());
                return new TextMessage(requestMap,"图片审核中...");
                //图片转换文字
            case WxCon.PIC_TO_TEXT_FLAG:
                FlagArgument.setFlag(WxCon.PIC_TO_TEXT_FLAG);
                System.out.println(FlagArgument.getFlag());
                return new TextMessage(requestMap,"转文字中...");
        }
        return null;
    }
}
