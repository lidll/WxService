package com.yz.controller;

import com.yz.dto.ResponseDto;
import com.yz.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName WxUserController
 * @Description TODO
 * @Author noah
 * @Date 3/17/21 11:26 AM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class WxUserController {

    @Autowired
    private WxService wxService;

    @GetMapping("/callback")
    public ResponseDto userFollow(HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String> params = wxService.parseRequest(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
