package com.zhuri.annotation.upms.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author :
 * @create : 2020-05-22 14:06
 * @description :
 */
//@Component
public class LifecycleBeanAware implements ApplicationContextAware {

	public LifecycleBeanAware() {
		System.out.println(LifecycleBeanAware.class.getName()+"开始执行构造方法....");
	}

	/**
	 * 生命周期初始化回调方法
	 */
	@PostConstruct
	public void postInit(){
		System.out.println(LifecycleBeanAware.class.getName()+"生命周期初始化回调方法 @PostConstruct 注解标识的方法.....");
	}

	/**
	 * ApplicationContextAware 回调方法
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(LifecycleBeanAware.class.getName()+"实现ApplicationContextAware 回调方法........");
	}
}
