package com.wisdom.annotation.upms.bean.condition;

/**
 * @author :
 * @create : 2019-05-24 17:45
 * @description :
 */
public class ComputerUser {
    private String suerName;
    /**
     * 使用的操作系统
     */
    private String operatingSystem;

    public ComputerUser(String suerName, String operatingSystem) {
        this.suerName = suerName;
        this.operatingSystem = operatingSystem;
    }

    public String getSuerName() {
        return suerName;
    }

    public void setSuerName(String suerName) {
        this.suerName = suerName;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
