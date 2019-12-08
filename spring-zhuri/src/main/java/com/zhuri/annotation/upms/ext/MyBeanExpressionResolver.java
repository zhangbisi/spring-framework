package com.zhuri.annotation.upms.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;

/**
 * @author :
 * @create : 2019-05-21 16:00
 * @description :
 *
 * bean表达式解释器:
 *  加载流程refresh之prepareBeanFactory（beanFactory）时，会手动设置 spring表达式解析器
 * org.springframework.context.support.AbstractApplicationContext#prepareBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 * 	模板默认以前缀“#{”开头，以后缀“}”结尾。如 @Value("#{user1.name}")
 *解析器什么时候使用
    就是在Bean进行初始化后会有属性填充的一步,方法如下:
    protected void populateBean(String beanName, RootBeanDefinition mbd, BeanWrapper bw) {
        //属性填充
        applyPropertyValues(beanName, mbd, bw, pvs);
    }
    最终会通过AbstractBeanFactory中的evaluateBeanDefinitionString方法进行解析
    然后这时候就进到StandardBeanExpressionResolver中的evaluate方法中进行解析了

 *
 */
public class MyBeanExpressionResolver implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        /**
         * 修改spring表达式语言模板 【#{“属性”}】
         */
        BeanExpressionResolver old=beanFactory.getBeanExpressionResolver();
        //重新自定义表达式的解析器
        StandardBeanExpressionResolver resolver = new StandardBeanExpressionResolver();
        resolver.setExpressionPrefix("%{");
        resolver.setExpressionSuffix("}");
        beanFactory.setBeanExpressionResolver(resolver);
        BeanExpressionResolver newRes =beanFactory.getBeanExpressionResolver();
        System.out.println("默认解析器="+old);

        System.out.println("自定义解析器="+newRes);
    }
}
