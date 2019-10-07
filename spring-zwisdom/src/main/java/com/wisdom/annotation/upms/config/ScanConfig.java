package com.wisdom.annotation.upms.config;

import com.wisdom.annotation.upms.controller.UpmsLogController;
import com.wisdom.annotation.upms.service.UpmsLogService;
import com.wisdom.annotation.upms.service.impl.UpmsLogServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author :
 * @create : 2019-05-28 18:42
 * @description :
 */
@Configuration
@ComponentScan(value = "com.wisdom.annotation.upms.controller")
public class ScanConfig {
    @Bean
    public UpmsLogService upmsLogService(){
        return new UpmsLogServiceImpl();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);
        UpmsLogController upmsLogController= applicationContext.getBean(UpmsLogController.class);
    }

}
