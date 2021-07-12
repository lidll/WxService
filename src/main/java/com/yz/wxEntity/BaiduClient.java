package com.yz.wxEntity;

import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.ocr.AipOcr;
import lombok.Data;

/**
 * @ClassName BaiduClient
 * @Description TODO
 * @Author noah
 * @Date 2019-08-27 15:58
 * @Version 1.0
 **/
@Data
public class BaiduClient {
    //文字识别
    public static final String WZSB_APP_ID = "17097758";
    public static final String WZSB_API_KEY = "NIQVKqci5SHsuQeZL8EmmlnZ";
    public static final String WZSB_SECRET_KEY = "MAPd0y6ATGErCILcB7qjRxVkVrxeHcxP";

    //内容审核
    public static final String NRSH_APP_ID = "17108139";
    public static final String NRSH_API_KEY = "vvplb7AdPGo9SkMq11vcuPmU";
    public static final String NRSH_SECRET_KEY = "1AGLZlUVOdR9BvLVIm2jAq2wSNScAt11";

    //文字识别客户端
    private static AipOcr aipOcr;
    public static AipOcr getAipOcr() {
        if(aipOcr == null){
            aipOcr = new AipOcr(WZSB_APP_ID, WZSB_API_KEY, WZSB_SECRET_KEY);
        }
        return aipOcr;
    }

    //内容审核客户端
    private static AipContentCensor aipContentCensor;
    public static AipContentCensor getAipContentCensor(){
        if (aipContentCensor == null) {
            aipContentCensor = new AipContentCensor(NRSH_APP_ID,NRSH_API_KEY,NRSH_SECRET_KEY);
        }
        return aipContentCensor;
    }
}
