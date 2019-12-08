package com.zhuri.annotation.upms.config;

import com.zhuri.annotation.upms.bean.myImpor.MyImportBeanDefinitionRegistrar;
import com.zhuri.annotation.upms.bean.myImpor.MyImportSelector;
import com.zhuri.annotation.upms.bean.myImpor.UpmsLogExample;
import com.zhuri.annotation.upms.bean.myImpor.UpmsOrganization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author :
 * @create : 2018-12-24 9:31
 * @description :
 * 给容器中注册组件：
 * @
 *
 */
@Configuration
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
public class ImportConfig {
    public static ApplicationContext getApplicationContext(Class clazz){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(clazz);
        return applicationContext;
    }

    public static void main(String[] args) {
        ApplicationContext context = getApplicationContext(ImportConfig.class);
        String[] beanNames = context.getBeanDefinitionNames();
        for(String name:beanNames){
            System.out.println("args = [" + name + "]");
        }
        UpmsOrganization organization = (UpmsOrganization)context.getBean(UpmsOrganization.class);
        UpmsLogExample logExample = (UpmsLogExample)context.getBean(UpmsLogExample.class);
    }
}
