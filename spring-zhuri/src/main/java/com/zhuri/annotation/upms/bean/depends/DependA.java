package com.zhuri.annotation.upms.bean.depends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :
 * @create : 2020-05-17 21:24
 * @description :
 *
 */
@Component
public class DependA {
	@Autowired
	DependB dependB;

	public DependA() {
		System.out.println("DependA 构造方法。。。。。");
	}
}
