package com.zhuri.annotation.upms.config;


import com.zhuri.annotation.upms.bean.lifecycle.UpmsRole;
import com.zhuri.annotation.upms.bean.lifecycle.UpmsUser;
import com.zhuri.annotation.upms.bean.lifecycle.UpmsUserRole;
import com.zhuri.annotation.upms.ext.MyBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :
 * @create : 2018-12-18 13:45
 * @description :
 * bean的生命周期：
 *         bean创建---初始化----销毁的过程
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 * 		对象创建完成，并赋值好，调用初始化方法。。。
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 * 		单实例：容器关闭的时候
 * 		多实例：容器不会管理这个bean；容器不会调用销毁方法；
 *
 * 1）、指定初始化和销毁方法；
 * 		通过@Bean指定init-method和destroy-method；
 * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
 * 				DisposableBean（定义销毁逻辑）;
 * 3）、可以使用JSR250；
 * 		@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
 * 		@PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * 4）、BeanPostProcessor【interface】：bean的后置处理器；
 * 		在bean初始化前后进行一些处理工作；
 * 		postProcessBeforeInitialization:在初始化之前工作
 * 		postProcessAfterInitialization:在初始化之后工作
 *
 * 源码
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * initializeBean
 *          applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *          invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 *          applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *
 *  BeanPostProcessor、
 *  InstantiationAwareBeanPostProcessor、 实例化回调 设置属性之前
 *  SmartInstantiationAwareBeanPostProcessor、 扩展InstantiationAwareBeanPostProcessor 添加一个回调函数，用于处理bean的最终类型
 *  MergedBeanDefinitionPostProcessor【internalPostProcessors】、 InstantiationAwareBeanPostProcessor之前调用 可以修改合并的bean定义。
 *  DestructionAwareBeanPostProcessor、销毁回调
 */
@Configuration
public class LifeCycleConfig {
    /**
     * 1、用 initMethod  destroyMethod
     * @return
     */
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public UpmsRole upmsRole(){
        return new UpmsRole(1,"tome1");
    }

    /**
     *2、通过让Bean实现InitializingBean（定义初始化逻辑），
     * 				DisposableBean（定义销毁逻辑）;
     */
    @Bean
    public UpmsUser upmsUser(){
        return new UpmsUser();
    }

    /**
     * 3、通过注解 标识   @PostConstruct  对象创建并赋值之后调用
     *                              @PreDestroy    容器移除对象之前
     *
     * @return
     */
    @Bean
    public UpmsUserRole upmsUserRole(){
        return new UpmsUserRole();
    }


    /**
     *  通过实现 BeanPostProcessor
     * @return
     */
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        MyBeanPostProcessor myBeanPostProcessor = (MyBeanPostProcessor)applicationContext.getBean(MyBeanPostProcessor.class);
    }
}
