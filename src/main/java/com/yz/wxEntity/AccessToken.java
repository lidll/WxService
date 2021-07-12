package com.yz.wxEntity;

import lombok.Data;

/**
 * @ClassName AccessToken
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 09:31
 * @Version 1.0
 **/
@Data
public class AccessToken {

    private String accessToken;
    private Long expireTime;

    public AccessToken(String accessToken,String expireIn){

        this.accessToken = accessToken;
        expireTime = System.currentTimeMillis() + Integer.parseInt(expireIn) * 1000;
    }

    /**
     *
     * @Author yz
     * @Description 判断accessToken是否过期
     * @Date 2019-08-27 09:35
     * @param
     * @return boolean
     */
    public boolean isExpired(){
        return System.currentTimeMillis() > expireTime;
    }
}
