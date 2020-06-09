package com.zhuri.annotation.upms.bean.depends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author :
 * @create : 2020-05-17 21:24
 * @description :
 */
@Component
public class DependB {
	@Autowired
	DependA dependA;

	public DependB(){
		System.out.println("构造方法。。。。。。。");
	}

	/**
	 * 生命周期初始化回调方法
	 */
	@PostConstruct
	public void dependBInit(){
		System.out.println("生命周期初始化回调方法 call z lifecycle init callback");
	}

}
