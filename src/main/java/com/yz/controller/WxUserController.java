package com.yz.controller;

import com.yz.domain.dto.ResponseDto;
import com.yz.utils.MessageFormatUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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


    @GetMapping("/callback")
    public ResponseDto userFollow(HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
            Map<String, String> params = MessageFormatUtil.parseRequest(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
