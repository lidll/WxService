package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ClassName WxServiceApplication
 * @Description TODO
 * @Author noah
 * @Date 2019-08-21 17:41
 * @Version 1.0
 **/
@SpringBootApplication
@ServletComponentScan
public class WxServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxServiceApplication.class,args);
    }
}
