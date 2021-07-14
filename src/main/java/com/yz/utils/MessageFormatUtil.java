package com.yz.utils;

import com.thoughtworks.xstream.XStream;
import com.yz.wxEntity.message.BaseMessage;
import com.yz.wxEntity.message.ImageMessage;
import com.yz.wxEntity.message.MusicMessage;
import com.yz.wxEntity.message.NewsMessage;
import com.yz.wxEntity.message.TextMessage;
import com.yz.wxEntity.message.VideoMessage;
import com.yz.wxEntity.message.VoiceMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MessageFormatUtil
 * @Description TODO
 * @Author noah
 * @Date 2021/7/12 18:59
 * @Version 1.0
 **/
public class MessageFormatUtil {


    /**
     * @param is
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @Author yz
     * @Description 解析xml为map
     * @Date 2019-08-23 17:55
     */
    public static Map<String, String> parseRequest(InputStream is) {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流,获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取根节点
            Element rootElement = document.getRootElement();
            //获取根节点的所有子节点
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }
            return map;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }


}
