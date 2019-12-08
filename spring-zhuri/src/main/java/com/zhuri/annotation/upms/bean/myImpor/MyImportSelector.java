package com.zhuri.annotation.upms.bean.myImpor;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author :
 * @create : 2019-05-24 18:06
 * @description :
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("importingClassMetadata 实现 ImportSelector 的方式注入bean[ com.wisdom.annotation.upms.bean.myImpor.UpmsOrganization ]");
        String[] beans = new String[1];
        beans[0] = "com.wisdom.annotation.upms.bean.myImpor.UpmsOrganization";
        return beans;
    }
}
