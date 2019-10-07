package com.wisdom.annotation.upms.config;

import com.wisdom.annotation.upms.bean.SeckillActive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :
 * @create : 2019-05-28 17:57
 * @description :
 *  1、合并beanDefinition,如果指定的bean是一个子bean的话,则遍历其所有的父bean
 *   具体案例 https://blog.csdn.net/lyc_liyanchao/article/details/82585752
 */
@Configuration
public class MergedBeanConfig {
    @Bean
    public SeckillActive seckillActive(){
        return  new SeckillActive();
    }
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MergedBeanConfig.class);
        SeckillActive seckillActive= applicationContext.getBean(SeckillActive.class);
    }
}
