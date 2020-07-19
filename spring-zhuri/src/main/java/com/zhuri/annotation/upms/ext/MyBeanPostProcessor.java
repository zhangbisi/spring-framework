package com.zhuri.annotation.upms.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author :
 * @create : 2018-12-18 14:49
 * @description : 扩展原理
 *
 *
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println();
        System.out.println(MyBeanPostProcessor.class.getName() +"第一步优先调用构造器初始化。。。。。。。。。。。。。。。。");
        System.out.println();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println();
        System.out.println(MyBeanPostProcessor.class.getName()+"第二步初始化之前...");
        System.out.println();
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println();
        System.out.println(MyBeanPostProcessor.class.getName()+"第三步初始化之后...");
        System.out.println();
        return bean;
    }

}
