package com.yz.utils;

import com.alibaba.fastjson.JSONObject;
import com.yz.wxEntity.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @ClassName AccessTokenService
 * @Description TODO
 * @Author noah
 * @Date 2021/7/12 17:24
 * @Version 1.0
 **/
@Component
@Slf4j
public class TokenUtil {

    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private static String APPID;

    private static String APPSECRET;

    private static String Token;

    private static AccessToken at;


    @Value("${wxCheck.token}")
    public void setToken(String token) {
        TokenUtil.Token = token;
    }

    @Value("${wxCheck.APPID}")
    public void setAPPID(String APPID){
        TokenUtil.APPID = APPID;
    }

    @Value("${wxCheck.APPSECRET}")
    public void setAPPSECRET(String APPSECRET){
        TokenUtil.APPSECRET = APPSECRET;
    }

    /**
     * @param
     * @return void
     * @Author yz
     * @Description 向wx获取accessToken
     * @Date 2019-08-27 09:21
     */
    private void getToken() {
        String url = GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        String result = HttpRequestUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String accessTokenStr = jsonObject.get("access_token").toString();
        String expiresIn = jsonObject.get("expires_in").toString();
        AccessToken accessToken = new AccessToken(accessTokenStr, expiresIn);
        at = accessToken;
    }

    /**
     *
     * @Author yz
     * @Description 校验
     * @Date 2021/7/12 17:28
     * @param signature
     * @param timestamp
     * @param nonce
     * @return boolean
     */
    public boolean check(String signature, String timestamp, String nonce) {
        // 1）将token、timestamp、nonce三个参数进行字典序排序≥≤
        String[] strings = {Token, timestamp, nonce};
        Arrays.sort(strings);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strings[0]);
        stringBuffer.append(strings[1]);
        stringBuffer.append(strings[2]);
        String s = stringBuffer.toString();
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        String encode = SHA1.encode(s);
        if (signature != null && signature.equals(encode)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @Author yz
     * @Description 提供系统获取accessToken
     * @Date 2021/7/12 17:29
     * @param
     * @return java.lang.String
     */
    public String getAccessToken() {
        if (at == null || at.isExpired()) {
            log.info("accessToken过期,重新获取");
            getToken();
        }
        log.info(at.getAccessToken());
        return at.getAccessToken();
    }

}
