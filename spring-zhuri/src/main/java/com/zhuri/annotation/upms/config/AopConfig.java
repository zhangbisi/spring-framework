package com.zhuri.annotation.upms.config;


import com.zhuri.annotation.upms.interceptor.UpmsLogAspects;
import com.zhuri.annotation.upms.service.UpmsLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author :
 * @create : 2019-05-25 10:43
 * @description :
 *
 *
 * AOP:
 *  1、导入AOP模块，spring-aop:spring-aop   aspectjrt   aspectjweaver
 *  2、定义一个业务逻辑类(BookServiceImpl),在业务逻辑运行时将日志进行打印
 *  3、定义一个日志切面类（LogAspects）：
 *      通知方法：
 *          前置通知 @Before  ：目标方法运行之前操作
 *          后置通知 @After ：目标方法运行之后操作
 *          返回通知 @AfterReturning ：目标方法运行返回正常之后
 *          异常通知 @AfterThrowing ：目标方法运行异常之后
 *          环绕通知 @Around 动态代理 手动推荐目标方法运行
 * 4、给切面的目标方法标注何时运行（通知注解）
 * 5、将切面类和业务类都加入到容器中
 * 6、必须告诉spring 哪个类是切面类（添加 @Aspect）
 * 7、给 config 配置类中添加注解 @EnableAspectJAutoProxy [开启基于注解的aop模式]
 *      在spring中很多的 @EnableXXXXXX
 *
 *  总结：
 *          第一，将业务逻辑组件和切面类都加入到容器中，告诉spring哪个类是切面类（@Aspect）
 *          第二，在切面类上的每个通知方法上标志通知注解，告诉spring何时运行（切入点表达式）
 *          第三，config中开启基于注解的AOP模式  @EnableAspectJAutoProxy
 *
 *
1、EnableAspectJAutoProxy
 @Import(AspectJAutoProxyRegistrar.class) 给容器导入AspectJAutoProxyRegistrar 类
 利用 AspectJAutoProxyRegistrar  自定义给容器中注册bean；

 容器中注册了 AnnotationAwareAspectJAutoProxyCreator.class


 2、AnnotationAwareAspectJAutoProxyCreator.class
 AspectJAwareAdvisorAutoProxyCreator
 AbstractAdvisorAutoProxyCreator
 AbstractAutoProxyCreator
 ProxyProcessorSupport
 SmartInstantiationAwareBeanPostProcessor

 *
 *
 */
@Configuration
//开启基于注解的aop
@EnableAspectJAutoProxy
@ComponentScan(value = "com.zhuri.annotation.upms.service")
public class AopConfig {
    //切面类加入容器
    @Bean
    public UpmsLogAspects upmsLogAspects(){
        return new UpmsLogAspects();
    }
   /*
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/zheng");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return  dataSource;
    }
*/
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UpmsLogService upmsLogService = applicationContext.getBean(UpmsLogService.class);
        upmsLogService.selectByPrimaryKey("2");
        upmsLogService.removeByPrimaryKey("1");
		System.out.println("upmsLogService内容信息 = [" + upmsLogService.getClass() + "]");
    }

}
