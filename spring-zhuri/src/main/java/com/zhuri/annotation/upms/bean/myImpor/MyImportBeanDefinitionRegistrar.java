package com.zhuri.annotation.upms.bean.myImpor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author :
 * @create : 2018-12-24 9:25
 * @description :
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata:当前类信息
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("MyImportBeanDefinitionRegistrar  调用 registerBeanDefinitions方法，开始注入 upmsLogExample 。。。。。。。。。");
        BeanDefinition definition = new RootBeanDefinition(UpmsLogExample.class);
        registry.registerBeanDefinition("upmsLogExample",definition);

        System.out.println("MyImportBeanDefinitionRegistrar  调用 registerBeanDefinitions方法， 结束注入 upmsLogExample 。。。。。。。。。");
    }

}
