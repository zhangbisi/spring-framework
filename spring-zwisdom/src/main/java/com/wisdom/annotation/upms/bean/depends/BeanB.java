package com.wisdom.annotation.upms.bean.depends;

/**
 * @author :
 * @create : 2019-05-28 18:58
 * @description :
 */
public class BeanB {

    private String name;

    private BeanC beanC;

    public BeanB() {
    }

    public BeanB(BeanC beanC, String name) {
        this.beanC = beanC;
        this.name = name;
    }

    public BeanC getBeanC() {
        return beanC;
    }

    public void setBeanC(BeanC beanC) {
        this.beanC = beanC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
