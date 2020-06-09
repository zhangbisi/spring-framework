package com.zhuri.annotation.upms.config;

import com.zhuri.annotation.upms.bean.depends.DependA;
import com.zhuri.annotation.upms.bean.depends.DependB;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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


    public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependsOnConfig.class);
		DependB dpb= applicationContext.getBean(DependB.class);
		DependA beanA = applicationContext.getBean(DependA.class);
		System.out.println("dpb = [" + dpb.getClass().getName() + "]");
		System.out.println("dpbClass = [" + dpb.getClass() + "]");
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
