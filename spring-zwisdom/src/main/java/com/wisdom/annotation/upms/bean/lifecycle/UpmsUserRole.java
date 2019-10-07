package com.wisdom.annotation.upms.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

public class UpmsUserRole implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer userRoleId;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 角色编号
     *
     * @mbg.generated
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;



    public UpmsUserRole() {
        System.out.println(UpmsUserRole.class.getName()+" constructor start 。。。。 ");
    }
    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println(UpmsUserRole.class.getName()+"  。。。。。@PostConstruct 。。。。");
    }

    //容器移除对象之前
    @PreDestroy
    public void destory(){
        System.out.println(UpmsUserRole.class.getName()+" 。。。。。@PreDestroy 。。。。");
    }








    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userRoleId=").append(userRoleId);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UpmsUserRole other = (UpmsUserRole) that;
        return (this.getUserRoleId() == null ? other.getUserRoleId() == null : this.getUserRoleId().equals(other.getUserRoleId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserRoleId() == null) ? 0 : getUserRoleId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }
}