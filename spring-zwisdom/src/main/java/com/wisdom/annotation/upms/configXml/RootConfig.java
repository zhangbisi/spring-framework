package com.wisdom.annotation.upms.configXml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author :
 * @create : 2019-08-25 22:48
 * @description :
 */
//spring 容器不扫描controller包. 相当于spring.xml
@ComponentScan(value = "com.misi.upms",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class RootConfig {

}
