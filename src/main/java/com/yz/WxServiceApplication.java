package com.yz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName WxServiceApplication
 * @Description TODO
 * @Author noah
 * @Date 2019-08-21 17:41
 * @Version 1.0
 **/
@ServletComponentScan
@MapperScan(value = "com.yz.dao")
@SpringBootApplication
public class WxServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WxServiceApplication.class, args);
    }
}

