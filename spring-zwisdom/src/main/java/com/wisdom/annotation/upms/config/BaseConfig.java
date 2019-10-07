package com.wisdom.annotation.upms.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :
 * @create : 2019-01-08 11:24
 * @description :
 */
public class BaseConfig {
    public static AnnotationConfigApplicationContext getApplicationContext(Class clazz){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(clazz);
        return applicationContext;
    }
}
