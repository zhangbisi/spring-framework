package com.wisdom.annotation.upms.bean;

import javax.xml.crypto.Data;

/**
 * @author :
 * @create : 2019-05-28 17:46
 * @description :
 */
public class BaseActive {
    private String id;
    private String name;
    private Data startDate;
    private Data endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getStartDate() {
        return startDate;
    }

    public void setStartDate(Data startDate) {
        this.startDate = startDate;
    }

    public Data getEndDate() {
        return endDate;
    }

    public void setEndDate(Data endDate) {
        this.endDate = endDate;
    }
}
