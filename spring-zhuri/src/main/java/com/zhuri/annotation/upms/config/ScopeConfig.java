package com.zhuri.annotation.upms.config;

import com.zhuri.annotation.ioc.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author :
 * @create : 2018-12-16 12:43
 * @description :
 * 1、@ComponentScan 配置扫描包：value=""   指定扫描包
 *      1.1、excludeFilters=   @Filter扫描的时候 按照规则排除哪些组件
 *      1.2  includeFilters= 扫描的时候值包含哪些组件
 *          FilterType.ANNOTATION  按照注解（常用）
 *          FilterType.ASSIGNABLE_TYPE 按照给定类型（常用）
 *          FilterType.ASPECTJ 按照ASPECTJ表达式
 *          FilterType.REGEX  按照正则表达式
 *          FilterType.CUSTOM 自定义规则
 *  2、
 *      2.1
 *      2.2
 *      2.3
 *      2.4
 *
 *
 *  3、
 *  4、
 *  5、
 *  6、
 */
@Configuration
@ComponentScan(value = "com.zhuri.annotation.upms") //自定义扫描规则
public class ScopeConfig {
    /**
     * 1、给容器中注册一个bean；类型为返回值类型，id默认是方法名
     * 2、修改bean在容器中的名字 @Bean("person")
     *
     * 3、@Scope:
     *      3.1:、 prototype 多实例 :ioc启动不会创建对象，只有每次获取的时候都调用创建方法去创建
     *              singleton 单实例（默认）：ioc启动时调用创建对象方法，把对象放到ioc中，以后调用直接从ioc中获取
     *              request 同一次请求创建一个实例
     *              session 同一次session创建一个实例
     *      3.2
     * @return
     */
    @Bean(value = "person")
    @Scope("prototype")
    public Person person3(){
        System.out.println("向容器中添加 Person 。。。。。。");
        return new Person();
    }

    @Bean(value = "person4")
    @Scope("singleton")
    @Lazy
    public Person person4(){
        System.out.println("向容器中添加 Person 。。。。。。");
        return new Person();
    }

}
