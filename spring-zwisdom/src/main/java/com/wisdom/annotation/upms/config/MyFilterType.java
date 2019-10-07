package com.wisdom.annotation.upms.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author :
 * @create : 2018-12-16 13:55
 * @description : 自定义扫描规则
 */
public class MyFilterType implements TypeFilter {
    /**
     *
     * @param metadataReader 读取当前扫描类的信息
     * @param metadataReaderFactory  可以获得任何类的信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取类的资源：类路径
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();

        if(className.contains("controller")){ //如果包含了controller 允许扫描
            System.out.println("---------->"+className);
            return true;
        }
        return false;
    }
}
