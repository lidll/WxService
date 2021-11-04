package com.yz.service.impl;
import com.yz.constant.CommandCon;
import com.yz.domain.entity.CommandEntity;
import com.yz.factory.CommandFactory;
import com.yz.strategy.CommandStrategy;
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
    private CommandFactory commandFactory;

    public String resolve(String content){
        CommandEntity commandEntity = EntityUtil.commandEntity(content);
        if (commandEntity == null) {
            return CommandCon.ERROR;
        }
        //策略+工厂 通过命令决定走哪个service
        CommandStrategy strategy = commandFactory.getStrategy(commandEntity.getService());
        return strategy.excute(commandEntity);
    }
}
