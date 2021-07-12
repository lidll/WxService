package com.yz.utils;

import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.ocr.AipOcr;
import com.yz.wxEntity.BaiduClient;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName PicAiUtil
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 14:50
 * @Version 1.0
 **/
public class PicAiUtil {
    /**
     *
     * @Author yz
     * @Description 获取图片文字
     * @Date 2019-08-27 15:53
     * @param url
     * @return java.lang.String
     */
    public static String getPicText(String url){

        AipOcr client = BaiduClient.getAipOcr();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        //通用文字识别（含位置信息版）500次/天
        JSONObject res = client.generalUrl(url, new HashMap<>());
        System.out.println(res.toString(2));

        List<com.alibaba.fastjson.JSONObject> jsonObjects = null;
        try {
            String s = res.toString();
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("words_result");
            jsonObjects = jsonArray.toJavaList(com.alibaba.fastjson.JSONObject.class);
        } catch (Exception e) {
            return "抱歉有点懵,请重新再上传尝试";
        }
        StringBuffer sb = new StringBuffer();
        for (com.alibaba.fastjson.JSONObject object : jsonObjects) {
            sb.append(object.get("words").toString());
            sb.append("\n");
        }
        return sb.toString();
    }

   /**
    *
    * @Author yz
    * @Description 图片审核
    * @Date 2019-08-27 16:37
    * @param url
    * @return java.lang.String
    */
    public static String checkPic(String url){
        // 初始化一个AipImageCensor
        AipContentCensor client = BaiduClient.getAipContentCensor();
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        JSONObject res = client.imageCensorUserDefined(url, EImgType.URL,null);
        System.out.println(res.toString(2));
        String s = res.toString();
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(s);
        String conclusion = jsonObject.get("conclusion").toString();
        switch (conclusion){
            case "合规":
                return conclusion;
            case "不合规":
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                List<com.alibaba.fastjson.JSONObject> jsonObjects = jsonArray.toJavaList(com.alibaba.fastjson.JSONObject.class);
                StringBuffer sb = new StringBuffer();
                for (com.alibaba.fastjson.JSONObject object : jsonObjects) {
                    sb.append(object.get("msg"));
                    sb.append("\n");
                }
                return conclusion + ":\n" +sb.toString();
        }
        return conclusion;
    }
}
