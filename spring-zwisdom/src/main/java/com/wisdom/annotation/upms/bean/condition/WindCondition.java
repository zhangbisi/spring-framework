package com.wisdom.annotation.upms.bean.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author :
 * @create : 2019-05-24 17:46
 * @description :
 */
public class WindCondition  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取运行环境信息
        Environment environment = context.getEnvironment();
        //获取bean的定义的注册信息
        BeanDefinitionRegistry definitionRegistry=context.getRegistry();

        String property = environment.getProperty("os.name");
        System.out.println("判断，确定设置的 computeruser的对象值");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }}
