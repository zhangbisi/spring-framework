package com.zhuri.annotation.config;

import com.zhuri.annotation.ioc.Person;
import com.zhuri.annotation.upms.config.ScanConfig;
import com.zhuri.annotation.upms.ext.MyBeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author :
 * @create : 2018-12-18 13:28
 * @description :
 * 1、
 */
public class BeanConfig {

    /**
     * @Bean 将bean注入到容器中
     * @return
     */
    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
    	return new MyBeanFactoryPostProcessor();
	}

	public static void main(String[] args) {

		/**
		 * 第一种写法
		 */

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//是否允许循环依赖
		ac.setAllowCircularReferences(true);
		ac.register(BeanConfig.class);
		ac.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
		//完成初始化spring容器
		ac.refresh();
		Person person = ac.getBean(Person.class);
		ac.getBeanDefinitionNames();
		System.out.println(person.getClass().getName());

		/**
		 * 第二种写法
		 */

//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
//		Person person = applicationContext.getBean(Person.class);
//		applicationContext.getBeanDefinitionNames();
//		System.out.println(person.getClass().getName());
	}
}
