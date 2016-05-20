
package com.library.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 图书管理员实体类
 * 
 * @author YanShuai
 * @version 1.0,2015年7月12日
 * @See
 * @since V1.0
 */
@Alias("manager")
public class Manager implements AbstractModel
{
    private static final long serialVersionUID = 4071354057780722536L;

    private String managerID;

    private String userName;

    private String password;

    private String sex;

    private String telephone;

    private String email;

    private Integer roleId;

    private Date createTime;

    /**
     * 用户的状态 0为正常 1为已删除
     */
    private Boolean status;

    private byte[] photo;

    public byte[] getPhoto()
    {
        return photo;
    }

    public void setPhoto(byte[] photo)
    {
        this.photo = photo;
    }

    public String getManagerID()
    {
        return managerID;
    }

    public void setManagerID(String managerID)
    {
        this.managerID = managerID;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Manager [managerID=" + managerID + ", userName=" + userName + ", password=" + password + ", sex=" + sex
                + ", telephone=" + telephone + ", email=" + email + ", roleId=" + roleId + ", createTime=" + createTime
                + ", status=" + status + "]";
    }

}