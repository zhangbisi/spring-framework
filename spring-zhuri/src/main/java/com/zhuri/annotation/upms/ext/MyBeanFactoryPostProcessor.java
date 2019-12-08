package com.zhuri.annotation.upms.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author :
 * @create : 2019-01-08 21:03
 * @description :
 * 扩展原理
 *
 *  BeanPostProcessor : bean 后置处理器，在bean初始化前后进行拦截工作

1、BeanFactoryPostProcessor：BeanFactory的后置处理器
        在BeanFactory标准初始化后调用,来制定和修改BeanFactory的内容；
        所有的bean定义已经保存加载到 BeanFactory，但是bean还没有实例
原理
        1）、ioc容器创建对象
        2)、invokeBeanFactoryPostProcessor

如何找到所有的并执行他们的方法
        1）、直接在BeanFactory 中找到所有类型是BeanFactoryPostProcessor的组件，并且执行他们的方法
        2）、在初始化创建其他组件前面执行

2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
    postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)；
    所有的bean定义信息 将要被加载，bean实例还未创建

    优先于BeanFactoryPostProcessor执行；
    利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件

 原理
    1）、ioc容器创建对象
    2）refresh() ----> invokeBeanFactoryPostProcessors(beanFactory);
    3) 从容器中获取所有的BeanDefinitionRegistryPostProcessor组件
        依次出发所有的postProcessBeanDefinitionRegistry()方法
        再来出发postProcessBeanFactory()方法

    4）、再从容器中找到 BeanFactoryPostProcessor 组件，依次出发postProcessBeanFactory() 方法

 *
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println();
        System.out.println("MyBeanFactoryPostProcessor ====================== postProcessBeanFactory(） ");
        System.out.println();

        int number = beanFactory.getBeanDefinitionCount();
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println("已经加载的bean的数量="+number);
        for(String name : names){
            System.out.println("beanName = [" + name + "]");
        }
        System.out.println();
    }
}
