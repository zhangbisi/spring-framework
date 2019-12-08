package com.zhuri.annotation.upms.bean.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author :
 * @create : 2019-05-24 18:18
 * @description :
 */
public class UpmsSystemFactory implements FactoryBean<UpmsSystem> {
    @Override
    public UpmsSystem getObject() throws Exception {
        return new UpmsSystem();
    }

    @Override
    public Class<?> getObjectType() {
        return UpmsSystem.class;
    }
}
