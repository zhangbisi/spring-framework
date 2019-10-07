package com.wisdom.annotation.upms.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author :
 * @create : 2019-01-09 10:53
 * @description :
 *
BeanDefinitionRegistryPostProcessor继承自BeanFactoryPostProcessor，
是一种比较特殊的BeanFactoryPostProcessor。
BeanDefinitionRegistryPostProcessor中定义的
postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)方法
可以让我们实现自定义的注册bean定义的逻辑。
通常向spring注册组件都是使用xml、@Bean注解或者@Component方式实现，这些方式都是静态的，不能通过程序来选择是否注册。
spring当然也提供了注册组件的扩展，就是 BeanDefinitionRegistryPostProcessor,
实现了BeanDefinitionRegistryPostProcessor的类可以获得BeanDefinitionRegistry 对象，通过它可以动态的注册组件。

在Mybatis与Spring的整合中，就利用到了BeanDefinitionRegistryPostProcessor来对Mapper的BeanDefinition进行了后置的自定义处理。

 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		GenericBeanDefinition definition = new GenericBeanDefinition();
		definition.setBeanClass(MyBeanDefinitionRegistryBean.class);    //设置类
		definition.setScope("singleton");       //设置scope
		definition.setLazyInit(false);          //设置是否懒加载
		definition.setAutowireCandidate(true);  //设置是否可以被其他对象自动注入
        int beanCount =  registry.getBeanDefinitionCount();
        System.out.println();
        System.out.println("MyBeanDefinitionRegistryPostProcessor  。。。。。。。。。。postProcessBeanDefinitionRegistry。。");
        System.out.println("bean此时没有实例化，数量="+beanCount);
        System.out.println();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println();
        System.out.println("bean注册的数量="+beanFactory.getBeanDefinitionCount());
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        System.out.println(Arrays.asList(beanNames));
        System.out.println();
    }
}
