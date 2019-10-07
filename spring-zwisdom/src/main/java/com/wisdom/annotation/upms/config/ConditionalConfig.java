package com.wisdom.annotation.upms.config;

import com.wisdom.annotation.upms.bean.condition.ComputerUser;
import com.wisdom.annotation.upms.bean.condition.LinuxCondition;
import com.wisdom.annotation.upms.bean.condition.WindCondition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

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
@ComponentScan(value = "com.wisdom.annotation.upms.bean.condition") //自定义扫描规则
public class ConditionalConfig {

    @Bean
    @Conditional({WindCondition.class})
    public ComputerUser computerUserWind(){
        return  new ComputerUser("Windows","Windows10");
    }
    @Bean
    @Conditional({LinuxCondition.class})
    public ComputerUser computerUserLinux(){
        return  new ComputerUser("Linux","centos7");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        ComputerUser computerUser= (ComputerUser)applicationContext.getBean(ComputerUser.class);
		System.out.println("suerName="+computerUser.getSuerName());
		System.out.println("className="+computerUser.getClass().getName());
    }
}
