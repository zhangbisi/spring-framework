package com.wisdom.annotation.upms.bean.myImpor;

public class UpmsLogExample {
    private String id;

    public UpmsLogExample(){
        System.out.println(UpmsLogExample.class.getName()+" 无参构造器的调用。。。。  ");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}