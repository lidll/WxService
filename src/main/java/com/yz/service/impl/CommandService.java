package com.yz.service.impl;

import com.yz.constant.CommandCon;
import com.yz.domain.entity.CommandEntity;
import com.yz.service.CommandStrategy;
import com.yz.utils.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CommandService
 * @Description 命令模式处理类
 * @Author noah
 * @Date 2021/7/14 15:17
 * @Version 1.0
 **/
@Service
public class CommandService {

    @Autowired
    private CommandHandler commandHandler;

    //菜谱的策略
    @Autowired
    private DishStrategy dishStrategy;

    public String resolve(String content){
        CommandEntity commandEntity = EntityUtil.commandEntity(content);
        if (commandEntity == null) {
            return CommandCon.ERROR;
        }
        if (CommandCon.SERVICE_NAME_DISH.equals(commandEntity.getService())){
            commandHandler.setCommandStrategy(dishStrategy);
        }
        return commandHandler.excute(commandEntity);


    }
}
