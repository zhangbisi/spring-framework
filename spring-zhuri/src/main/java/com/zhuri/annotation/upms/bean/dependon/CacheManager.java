package com.zhuri.annotation.upms.bean.dependon;

/**
 * @author :
 * @create : 2020-06-12 16:31
 * @description : CacheManager 依赖 SystemSettings
 */
public class CacheManager {
	public CacheManager(){
		System.out.println("执行调度任务时必须依赖参数："+SystemSettings.REFRESH_CYCLE);
	}

}
