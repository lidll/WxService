package com.yz.service.impl;

import com.yz.constant.CommandCon;
import com.yz.domain.entity.CommandEntity;
import com.yz.service.CommandStrategy;
import com.yz.service.DishInfoService;
import com.yz.utils.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CommonHandler
 * @Description TODO
 * @Author noah
 * @Date 2021/7/14 16:29
 * @Version 1.0
 **/
@Service
public class CommandHandler{

    private CommandStrategy commandStrategy;

    public void setCommandStrategy(CommandStrategy commandStrategy) {
        this.commandStrategy = commandStrategy;
    }

    public String excute(CommandEntity commandEntity){
        return commandStrategy.excute(commandEntity);
    }

}
