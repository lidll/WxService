package com.yz.strategy;

import com.yz.domain.entity.CommandEntity;

/**
 * @ClassName commondHandler
 * @Description 执行命令接口
 * @Author noah
 * @Date 2021/7/14 16:01
 * @Version 1.0
 **/
public interface CommandStrategy {

    /**
     *
     * @Author yz
     * @Description 执行命令及参数
     * @Date 2021/7/14 16:02
     * @param commandEntity
     * @return int
     */
    String excute(CommandEntity commandEntity);
}
