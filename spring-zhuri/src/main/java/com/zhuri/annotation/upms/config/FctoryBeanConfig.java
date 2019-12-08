package com.zhuri.annotation.upms.config;

import com.zhuri.annotation.upms.bean.factory.UpmsSystemFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :
 * @create : 2019-01-08 11:24
 * @description :
 *
 *
 *
 */
@Configuration
public class FctoryBeanConfig extends BaseConfig {
    @Bean
    public UpmsSystemFactory upmsSystemFactory(){
        return new UpmsSystemFactory();
    }

    public static void main(String[] args) {
        ApplicationContext context = getApplicationContext(FctoryBeanConfig.class);

        //com.misi.annotation.bean.CommodityFctoryBean
        Object object = context.getBean(UpmsSystemFactory.class);
        System.out.println("工厂bean得到的是"+ object.getClass() +"类型");

        //别名获取调用的是 getObject()方法  返回com.misi.annotation.bean.Commodity
        Object object2 = context.getBean("upmsSystemFactory");
        //com.misi.annotation.bean.Commodity
        System.out.println("工厂bean得到的是"+ object2.getClass() +"类型");
        //com.misi.annotation.bean.CommodityFctoryBean
        Object object3 = context.getBean("&upmsSystemFactory");
        System.out.println("&upmsSystemFctory 工厂bean得到的是"+ object3.getClass() +"类型");

        String[] names = context.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println("beanName = [" + name + "]");
        }
    }
}
