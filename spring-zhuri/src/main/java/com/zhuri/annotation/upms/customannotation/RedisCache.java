package com.zhuri.annotation.upms.customannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :
 * @create : 2020-07-01 16:47
 * @description :
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
	/**
	 * 缓存key
	 * @return
	 */
	String cacheKey();

	/**
	 * 缓存过期时间
	 * @return
	 */
	long expireTime() default 10;
}
