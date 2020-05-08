package com.damu.entity;

import sun.rmi.server.UnicastServerRef;

import java.util.Date;

/**
 * @author passionlife
 */
public class Users {
    private Integer id;                         //用户id
    private String username;                    //用户账号
    private String userpass;                    //用户密码
    private String nickname;                    //用户昵称
    private Integer age;                        //年龄
    private String gender;                      //性别
    private String phone;                       //联系方式
    private String email;                       //邮箱
    private Date createTime;                     //账号创建时间
    private Date updateTime;                    //账号最后修改时间
    private Date lastLogin;                     //账号最后登陆时间
    private Integer userStatus;                 //用户状态 0 正常 1 锁定 2 删除
    private String remark;                      //用户备注信息

    public Users(){}

    public Users(Integer id) {
        this.id = id;
    }

    public Users(String username, String userpass, String nickname, Integer age, String gender, String phone, String email, Date createTime, Date updateTime, Date lastLogin, Integer userStatus, String remark) {
        this.username = username;
        this.userpass = userpass;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLogin = lastLogin;
        this.userStatus = userStatus;
        this.remark = remark;
    }

    public Users(Integer id, String nickname, Integer age, String gender, String phone, String email, Date updateTime, String remark) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String password) {
        this.userpass = userpass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastLogin=" + lastLogin +
                ", userStatus=" + userStatus +
                ", remark='" + remark + '\'' +
                '}';
    }
}
