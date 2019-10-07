package com.wisdom.annotation.upms.config;

import com.wisdom.annotation.upms.bean.depends.BeanA;
import com.wisdom.annotation.upms.bean.depends.BeanB;
import com.wisdom.annotation.upms.bean.depends.BeanC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :
 * @create : 2019-05-28 18:42
 * @description :
 */
@Configuration
public class DependsOnConfig {
    @Bean
    public BeanA beanA(){
        BeanC c = new BeanC();
        BeanB b = new BeanB(c,"b依赖c");
        return new BeanA(b,"A依赖B");
    }
    @Bean
    public BeanB beanB(){
        return new BeanB();
    }
    @Bean
    public BeanC beanC(){
        return new BeanC();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependsOnConfig.class);
        BeanC beanC= applicationContext.getBean(BeanC.class);
    }
}
