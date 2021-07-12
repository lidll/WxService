package com.yz.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName HttpRequestUtil
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 09:14
 * @Version 1.0
 **/
public class HttpRequestUtil {

    /**
     *
     * @Author yz
     * @Description 执行get请求
     * @Date 2019-08-27 09:32
     * @param url
     * @return java.lang.String
     */
    public static String get(String url){
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            InputStream is = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = is.read(bytes)) != -1) {
                sb.append(new String(bytes,0,len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Author yz
     * @Description 向指定的地址发送一个post请求
     * @Date 2019-08-27 10:44
     * @param url
    * @param data
     * @return java.lang.String
     */
    public static String post(String url,String data){
        try {
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            //要发送数据,必须设置为可发送数据状态
            connection.setDoOutput(true);
            //获取输出流
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(data.getBytes());
            outputStream.close();
            //获取输入流
            InputStream is = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = is.read(bytes)) != -1) {
                sb.append(new String(bytes,0,len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
