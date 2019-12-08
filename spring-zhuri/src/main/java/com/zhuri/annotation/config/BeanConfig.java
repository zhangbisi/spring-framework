package com.zhuri.annotation.config;

import com.zhuri.annotation.ioc.Person;
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

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person.getClass().getName());
	}
}
