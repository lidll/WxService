package com.yz.config;

import com.yz.annotation.anno.Log;
import com.yz.constant.RedisKeyCon;
import com.yz.domain.DO.DishInfoDO;
import com.yz.service.DishInfoService;
import com.yz.utils.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DishRunner
 * @Description TODO
 * @Author noah
 * @Date 2021/7/15 10:45
 * @Version 1.0
 **/
@Component
@Slf4j
public class DishRunner implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private DishInfoService dishInfoService;

    @Override
    @Log(functionName = "加载菜谱Runner")
    public void run(String... args) throws Exception {
        List<DishInfoDO> list = dishInfoService.list(null);
        if (ListUtil.isNotEmpty(list)) {
            SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
            list.forEach(x->opsForSet.add(RedisKeyCon.DISH_SERVICE_REDIS_KEY,x.getName()));
            log.info(opsForSet.members(RedisKeyCon.DISH_SERVICE_REDIS_KEY).toString());
        }
    }
}
