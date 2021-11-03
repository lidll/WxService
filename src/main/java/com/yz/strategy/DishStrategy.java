package com.yz.strategy;

import com.alibaba.fastjson.JSON;
import com.yz.constant.CommandCon;
import com.yz.domain.DO.DishInfoDO;
import com.yz.domain.entity.CommandEntity;
import com.yz.service.DishInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName DishStrategy
 * @Description 菜谱执行策略
 * @Author noah
 * @Date 2021/7/14 17:19
 * @Version 1.0
 **/
@Component
public class DishStrategy implements CommandStrategy {

    @Autowired
    private DishInfoService dishInfoService;

    @Override
    public String excute(CommandEntity commandEntity) {
        switch (commandEntity.getMethod()){
            case CommandCon.ADD:
                DishInfoDO dishInfoDO = new DishInfoDO(commandEntity.getValue());
                if (dishInfoService.save(dishInfoDO) > 0) {
                    return CommandCon.SUCCESS;
                }
                return CommandCon.ERROR;
            case CommandCon.REM:
                if (dishInfoService.remove(Integer.parseInt(commandEntity.getValue())) > 0) {
                    return CommandCon.SUCCESS;
                }
                return CommandCon.ERROR;
            case CommandCon.EDIT:

            case CommandCon.LIST:
                List<DishInfoDO> list = dishInfoService.list(null);
                HashMap<Object, Object> resultMap = new HashMap<>();
                for (DishInfoDO infoDO : list) {
                    resultMap.put(infoDO.getId(),infoDO.getName());
                }
                return JSON.toJSONString(resultMap);
        }
        return CommandCon.ERROR;
    }
}
