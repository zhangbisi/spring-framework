package com.wisdom.annotation.upms.bean.depends;

/**
 * @author :
 * @create : 2019-05-28 18:58
 * @description :
 */
public class BeanA {
    private String name;
    private BeanB beanB;

    public BeanA() {
    }

    public BeanA(BeanB beanB, String name) {
        this.beanB = beanB;
        this.name = name;
    }

    public BeanB getBeanB() {
        return beanB;
    }

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
