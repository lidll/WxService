//package com.yz.config;
//
//import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.naming.NamingService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;

/**
 * @ClassName NacosResigster
 * @Description TODO
 * @Author noah
 * @Date 6/4/21 5:55 PM
 * @Version 1.0
 **/
//@Component
//public class NacosResigster implements CommandLineRunner {
//
//    @NacosInjected
//    private NamingService namingService;
//
//    @Value("${spring.application.name}")
//    private String applicationName;
//
//    @Value("${server.port}")
//    private int serverPort;
//
//    /**
//     * Callback used to run the bean.
//     *
//     * @param args incoming main method arguments
//     * @throws Exception on error
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        namingService.registerInstance(applicationName,"127.0.0.1",serverPort);
//    }
//}
