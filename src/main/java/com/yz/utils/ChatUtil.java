package com.yz.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ChatUtil
 * @Description TODO
 * @Author noah
 * @Date 2019-08-26 16:25
 * @Version 1.0
 **/
public class ChatUtil {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1 547.66 Safari/537.36";
    //"http://op.juhe.cn/iRobot/index" 聚合数据聊天机器人
    //青云客聊天机器人
    public static String REQUEST_URL = "http://api.qingyunke.com/api.php";
    //聚合机器人appkey
    private static final String APPKEY = "7bca2c3f460186f1b5d2d038a4db956a";

    //1.问答
    public static String getRequest(String content){
        String result = null;
        String url = REQUEST_URL;
        Map param = new HashMap();
        //聚合数据机器人
//        param.put("key",APPKEY);
//        param.put("info",content);//发给机器人的内容,不超过30字符
//        param.put("dtype","");//返回的数据格式 json或者xml 默认json
//        param.put("loc","");//地点
//        param.put("lon","");//经度
//        param.put("lat","");//纬度
//        param.put("userid",userid);//1~32位 联系上下文

        param.put("key","free");
        param.put("appid","0");
        param.put("msg",content);
        result = net(url,param,"GET");
        JSONObject object = JSONObject.parseObject(result);
//        if ("0".equals(object.getString("error_code"))) {
//            String result1 = object.get("result").toString();
//            JSONObject jsonObject = JSONObject.parseObject(result1);
//            String text = jsonObject.get("text").toString();
//            System.out.println(text);
//            return text;
//        }else{
//            System.out.println(object.get("error_code") + ":" + object.get("reason"));
//            return object.get("error_code") + ":" + object.get("reason");
//        }

        if (object.getInteger("result") == 0) {
            String content1 = object.get("content").toString();
            return content1;
        }else{
            return object.get("result") + ":" + object.get("content");
        }
    }

    /**
     *
     * @Author yz
     * @Description 网络请求
     * @Date 2019-08-26 15:55
     * @param strUrl
     * @param param
     * @param method
     * @return java.lang.String
     */
    private static String net(String strUrl, Map param, String method){
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;

        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl =  strUrl + "?" +urlencode(param);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection)url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent",userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (param != null && method.equals("POST")) {
                DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());
                dataOutputStream.writeBytes(urlencode(param));
            }
            InputStream inputStream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream,DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }

        }
        return rs;
    }

    private static String urlencode(Map<String,Object> data) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
