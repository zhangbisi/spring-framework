package com.zhuri.annotation.upms.bean.depends;

/**
 * @author :
 * @create : 2019-05-28 18:58
 * @description :
 */
public class BeanC {
    private String name;
    
    private BeanA beanA;

    public BeanC() {
    }

    public BeanC(BeanA beanA,String name) {
        this.beanA = beanA;
        this.name = name;
    }

    public BeanA getBeanA() {
        return beanA;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
