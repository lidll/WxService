package com.yz;

import com.yz.domain.DO.DishInfoDO;
import com.yz.service.DishInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @ClassName RedisTemplateTest
 * @Description TODO
 * @Author noah
 * @Date 2021/7/15 10:55
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private DishInfoService dishInfoService;

    @Test
    public void test(){
        stringRedisTemplate.opsForSet().add("set1","1","2","3","4","5");
        System.out.println(stringRedisTemplate.opsForSet().randomMember("set1"));
        System.out.println(stringRedisTemplate.opsForSet().randomMember("set1"));
        System.out.println(stringRedisTemplate.opsForSet().randomMember("set1"));
        System.out.println("members: " + stringRedisTemplate.opsForSet().members("set1"));
        System.out.println(stringRedisTemplate.keys("*"));
    }

    @Test
    public void addDish(){
        String[] dishMenu = {"炒菜","烫饭","泡面","拉面","擂饭","盖浇饭","饺子","羊肉粉","牛肉面","面包","黄焖鸡","喷射套餐","生烫"};
        for (String menu : dishMenu) {
            DishInfoDO dishInfoDO = new DishInfoDO(menu);
            dishInfoService.save(dishInfoDO);
        }
    }
}
