package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Entity
@Table(name = "t_account")
public class Account implements Serializable{


    public static final String USER_STATE_OK = "正常";
    public static final String USER_STATE_DISABLE = "禁用";
    public static final String SESSION_KEY = "curr_user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountName;
    private String password;
    private String accountTel;
    private String loginName;
    private String logintime;
    private String loginIp;
    private String createtime;
    private String state;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountTel() {
        return accountTel;
    }

    public void setAccountTel(String accountTel) {
        this.accountTel = accountTel;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
