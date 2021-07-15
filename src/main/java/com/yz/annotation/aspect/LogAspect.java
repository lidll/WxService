package com.yz.annotation.aspect;

import com.yz.annotation.anno.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName TimeWatchAspect
 * @Description TODO
 * @Author noah
 * @Date 2021/7/15 11:20
 * @Version 1.0
 **/
@Component
@Aspect
public class LogAspect {

    public static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.yz.annotation.anno.Log)")
    public void timeWatchPointCut(){

    }

    @Around("timeWatchPointCut()")
    public void timeWatchAround(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        logger.info("!!!--------------------------" + log.functionName() + " 执行时间 :" + time + "ms -------------------------!!!");
    }
}
