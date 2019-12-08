package com.zhuri.annotation.upms.configXml.webXml;/*
package com.wisdom.annotation.upms.configXml.webXml;

import com.wisdom.annotation.upms.configXml.AppConfig;
import com.wisdom.annotation.upms.configXml.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

*/
/**
 * @author :
 * @create : 2019-08-25 22:28
 * @description :
 *//*

//web容器启动的时候创建对象，调用方法来初始化容器与控制器
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取跟容器的配置类（spring 配置文件）父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //获取web容器配置（spring mvc配置文件）子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //   /:拦截所有请求（包括静态资源：xx.js  xx.css,xx.png）但是不包括 *.jsp
    //   /*: 拦截所有请求 包括 ：*.jsp
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
*/
