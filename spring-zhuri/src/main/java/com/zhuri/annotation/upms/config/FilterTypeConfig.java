package com.zhuri.annotation.upms.config;

import com.zhuri.annotation.ioc.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author :
 * @create : 2018-12-16 12:43
 * @description :
 *
 * 1、@ComponentScan 配置扫描包：value=""   指定扫描包
 *      1.1、excludeFilters=   @Filter扫描的时候 按照规则排除哪些组件
 *      1.2  includeFilters= 扫描的时候值包含哪些组件
 *          FilterType.ANNOTATION  按照注解（常用）
 *          FilterType.ASSIGNABLE_TYPE 按照给定类型（常用）
 *          FilterType.ASPECTJ 按照ASPECTJ表达式
 *          FilterType.REGEX  按照正则表达式
 *          FilterType.CUSTOM 自定义规则
 *
 *
 *  2、给容器中注入组件
 *     1）、包扫描+组件标识注解（@ComponentScan + @Controller/@Service/@Repository/@Component）
 *     2）、@Bean 导入第三方包里面的组件
 *     3）、@Import 快速给容器导入组件
 *          @Import 要导入容器的组件，容器会自动注入这个组件，id默认全类名
 *          ImportSelector 返回需要注入容器的全类名数组
 *          ImportBeanDefinitionRegistrar 手动注册bean到容器中
 *    4）、使用spring提供的FactoryBean（工厂bean）
 *          默认获取得到的是工厂bean调用getObject() 方法创建的对象
 *          如果需要获取bean 本身，我们需要给id前面加 &
 *              Object object3 = context.getBean("&commodityFctory");
 *
 *  3、
 *  4、
 *  5、
 *  6、
 */
//Configuration 配置基础类 == 配置文件 告诉spring这是个配置类
@Configuration
//@ComponentScan("com.misi.annotation")   //配置包扫描
//@ComponentScan(value = "com.misi.annotation",excludeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Repository.class)} )  //指定扫描,不扫描@Repository标记的类
//@ComponentScan(value = "com.misi.annotation",includeFilters = {@ComponentScan.Filter(type =FilterType.ANNOTATION,classes = Controller.class)}, useDefaultFilters = false)//扫描的时候只包含@Controller组件标记的类
@ComponentScan(value = "com.zhuri.annotation.upms",includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilterType.class)
},useDefaultFilters = false) //自定义扫描规则
public class FilterTypeConfig {

    /**
     * 1、给容器中注册一个bean；类型为返回值类型，id默认是方法名
     * 2、修改bean在容器中的名字 @Bean("person")
     * @return
     */
    //@Bean
    @Bean(value = "person")
    public Person person2(){
        return new Person("tom",22);
    }
}
