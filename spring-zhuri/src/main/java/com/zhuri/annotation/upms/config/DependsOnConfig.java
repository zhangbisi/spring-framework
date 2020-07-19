package com.zhuri.annotation.upms.config;

import com.zhuri.annotation.upms.bean.dependon.CacheManager;
import com.zhuri.annotation.upms.bean.dependon.SystemSettings;
import com.zhuri.annotation.upms.bean.depends.DependA;
import com.zhuri.annotation.upms.bean.depends.DependB;
import com.zhuri.annotation.upms.bean.factory.UpmsSystemFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author :
 * @create : 2019-05-28 18:42
 * @description :
 *循环依赖必须是单列、必须是set注入 不能构造器注入
 *
 */
@Configuration
@ComponentScan(value = "com.zhuri.annotation.upms.bean.depends")
public class DependsOnConfig {

	@Bean
	public UpmsSystemFactory upmsSystemFactory(){
		return new UpmsSystemFactory();
	}

	/**
	 * 用于测试 String[] dependsOn = mbd.getDependsOn(); 方法
	 * TODO [笔记]什么时候回有值呢
	 * @return
	 */
	@Bean
	@DependsOn("systemSettings")
	public CacheManager cacheManager(){
		return new CacheManager();
	}
	@Bean
	public SystemSettings systemSettings(){
		return new SystemSettings();
	}

    public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependsOnConfig.class);
		DependB dpb= applicationContext.getBean(DependB.class);
		DependA beanA = applicationContext.getBean(DependA.class);
		//bean的名称前面加了& 获取到的是 UpmsSystemFactory
		Object beanFactory = applicationContext.getBean("&upmsSystemFactory");
		System.out.println("dpb = [" + dpb.getClass().getName() + "]");
		System.out.println("dpbClass = [" + dpb.getClass() + "]");
		System.out.println("UpmsSystem = [" + beanFactory.getClass() + "]");
	}

	/**
	 * 第二种写法
	 * 关闭循环依赖
	 */
	@Test
	public void setAllowCircularReferences(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.setAllowCircularReferences(false);
		context.register(DependsOnConfig.class);
		context.refresh();
	}
}
