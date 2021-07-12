package com.yz.controller.callback;

import com.yz.service.WxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName CallBackController
 * @Description TODO
 * @Author noah
 * @Date 2019-09-26 17:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/callback")
@Slf4j
public class CallBackController {

    @Autowired
    private WxService wxService;

    @PostMapping("/success")
    public void success(HttpServletRequest request){
        log.info("/callback/success~~~~~~~~~~~~~~~~~");
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String> params = wxService.parseRequest(request.getInputStream());
            log.info("接收消息:" + params.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
