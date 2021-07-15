package com.yz;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;
import com.baidu.aip.ocr.AipOcr;
import com.thoughtworks.xstream.XStream;
import com.yz.utils.TokenUtil;
import com.yz.wxEntity.BaiduClient;
import com.yz.wxEntity.button.*;
import com.yz.wxEntity.message.*;
import com.yz.service.impl.WxService;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @ClassName ImageTest
 * @Description TODO
 * @Author noah
 * @Date 2019-08-22 15:04
 * @Version 1.0
 **/

public class ImageTest {

    @Autowired
    WxService wxService;

    @Autowired
    TokenUtil tokenUtil;

    @Test
    public void imageIOTest(){
        File file = new File("/Users/noah/Desktop/ezpy_deptTemplate.jpg");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            System.out.println("文件大小:"+fileInputStream.available()/1024+"kb");

            BufferedImage read = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //写入流中
            ImageIO.write(read, "jpg", baos);
            int length = baos.toByteArray().length;
            System.out.println("ImageIO转换后大小:"+length/1024+"KB-=-==-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==");


            Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
            if (iter.hasNext()) {
                ImageWriter writer = iter.next();
                ImageWriteParam param = writer.getDefaultWriteParam();
               // ImageOutputStream imageOutputStream = new FileImageOutputStream(new File(""));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.92f);
                try {
                    //断点测试只允许使用ImageOutputStream类型输出流
                    writer.setOutput(byteArrayOutputStream);
                    writer.write(null, new IIOImage(read, null, null), param);
                    writer.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("===异常了==");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void entityToXml(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("ToUserName","qwe");
        map.put("FromUserName","form");
        TextMessage textMessage = new TextMessage(map, "好饿");
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMessage.class);
        xStream.processAnnotations(ImageMessage.class);
        xStream.processAnnotations(MusicMessage.class);
        xStream.processAnnotations(NewsMessage.class);
        xStream.processAnnotations(VideoMessage.class);
        xStream.processAnnotations(VoiceMessage.class);
        String s = xStream.toXML(textMessage);
        System.out.println(s);
    }

    @Test
    public void getToken(){
        tokenUtil.getAccessToken();
    }

    @Test
    public void testBUtton(){
        Button button = new Button();

        button.getButton().add(new ClickButton("一级点击","1"));
        button.getButton().add(new ViewButton("一级点击","www.baidu.com"));
        SubButton subButton = new SubButton("有子菜单");
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图","31"));
        subButton.getSub_button().add(new ClickButton("点击子菜单","32"));
        subButton.getSub_button().add(new ViewButton("123123","31"));
        button.getButton().add(subButton);

        String s = JSON.toJSONString(button);
        System.out.println(s);
    }

    //设置APPID/AK/SK
    public static final String APP_ID = "17097758";
    public static final String API_KEY = "NIQVKqci5SHsuQeZL8EmmlnZ";
    public static final String SECRET_KEY = "MAPd0y6ATGErCILcB7qjRxVkVrxeHcxP";

    @Test
    public void testPic(){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String path = "/Users/noah/Desktop/WX20190827-144939@2x.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }

    @Test
    public void checkPic(){
        // 初始化一个AipImageCensor
        AipContentCensor client = BaiduClient.getAipContentCensor();
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String path = "/Users/noah/Desktop/WechatIMG161.jpeg";
        JSONObject res = client.imageCensorUserDefined(path, EImgType.FILE,null);
        System.out.println(res.toString(2));
    }

//    @Test
//    public void industryTest(){
//        TemplateMessageManager.getIndustry();
//    }

    @Test
    public void testFormat(){
        int i = 132;
        String format = String.format("%05d", i);

        System.out.println(format);
    }
}
