package com.yz.factory;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yz.strategy.CommandStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @ClassName CommandFactory
 * @Description 命令类工厂
 * @Author noah
 * @Date 2021/11/3 15:29
 * @Version 1.0
 **/
@Service
public class CommandFactory {

    @Autowired
    private Map<String, CommandStrategy> commandStrategyMap = new ConcurrentHashMap<>();

    public CommandStrategy getStrategy(String serviceName){
        CommandStrategy commandStrategy = commandStrategyMap.get(serviceName);
        if (Objects.isNull(commandStrategy)) {
            throw new RuntimeException("未找到对应的命令策略!!!!!!!!!!");
        }
        return commandStrategy;
    }
}
