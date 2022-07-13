package com.yz.controller.test;

import com.yz.domain.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author noah
 * @Date 2022/7/13 16:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("/bitmap")
public class TestController {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @GetMapping("/set")
    public ResponseDto setBit(@RequestParam("key") String key){
        Calendar instance = Calendar.getInstance();
        int dayOfYear = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println("今天是今年的第" + dayOfYear +"天");
        Boolean execute = redisTemplate.execute((RedisCallback<Boolean>) con -> con.setBit(key.getBytes(StandardCharsets.UTF_8), dayOfYear + 1, true));
        return ResponseDto.success(200,execute);
    }

    @GetMapping("/count")
    public ResponseDto countBit(@RequestParam("key")String key){
        Long execute = redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(key.getBytes(StandardCharsets.UTF_8)));
        return ResponseDto.success(200,execute);
    }
}
