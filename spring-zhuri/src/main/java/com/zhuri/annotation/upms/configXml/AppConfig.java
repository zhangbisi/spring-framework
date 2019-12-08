package com.zhuri.annotation.upms.configXml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author :
 * @create : 2019-08-25 22:48
 * @description :
 */
//spring mvc的容器 只扫描controller  相当于spring-mvc.xml
// useDefaultFilters = false  禁用默认的过滤规则
@ComponentScan(value ="com.misi.upms",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
public class AppConfig {
}
