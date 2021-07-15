package com.yz.controller.success;

import com.yz.utils.MessageFormatUtil;
import com.yz.utils.TokenUtil;
import com.yz.service.impl.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName WxCheckController
 * @Description TODO
 * @Author noah
 * @Date 2019-08-21 17:43
 * @Version 1.0
 **/
@RestController
@RequestMapping("/wx")
public class WxSuccessController {

    private static final Logger log = LoggerFactory.getLogger(WxSuccessController.class);

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    WxService wxService;
    /**
     *
     * @Author yz
     * @Description 接入公众号接口
     * @Date 2019-08-23 15:30
     * @param request
     * @param response
     * @return void
     */
    @GetMapping("/access")
    public void testGet(HttpServletRequest request,HttpServletResponse response){
        log.info("GET /wx/access ~~~~~~~~~~~~~~~~~");
        //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");
        log.info("公众号接入:");
        log.info("signature:" + signature);
        log.info("timestamp:" + timestamp);
        log.info("nonce:" + nonce);
        log.info("echostr:" + echostr);

        try {
            if (tokenUtil.check(signature, timestamp,nonce)){
                PrintWriter writer = response.getWriter();
                writer.print(echostr);
                writer.flush();
                writer.close();
                log.info("接入公众平台成功!");
            }else{
                log.info("接入公众平台失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     *
     * @Author yz
     * @Description 回复用户消息
     * @Date 2019-08-23 15:30
     * @param request
     * @param response
     * @return void
     */
    @PostMapping("/access")
    public void testPost(HttpServletRequest request,HttpServletResponse response){
        log.info("POST /wx/access ~~~~~~~~~~~~~~~~~");
        try {
            request.setCharacterEncoding("UTF-8");
            //转换消息为map
            Map<String, String> params = MessageFormatUtil.parseRequest(request.getInputStream());
            log.info("回复用户消息接口>接收消息:" + params.toString());
            //消息处理
            String messageStr = wxService.getResponse(params);
            if (messageStr == null) {
                return ;
            }
            log.info("回复消息:" + messageStr);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/xml; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(messageStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
