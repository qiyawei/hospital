package com.kaishengit.action;

import com.kaishengit.exception.LockedException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
public class HomeAction extends BaseAction {

    private String loginName;
    private String password;
    private String code;

    @Inject
    private AccountService accountService;


    @Action("/index")
    @Override
    public String execute() throws Exception {
       return SUCCESS;
    }

    @Action(value = "/home",results={
        @Result(name = "error",type = "redirectAction",params = {
                "actionName","index","namespace","/","code","${code}"
        }),
        @Result(name = "locked",type = "redirectAction",params = {
                "actionName","index","namespace","/","code","${code}"
        })
    })
    public String login(){
        try {
            Account account = accountService.findUserByName(loginName,password);
            return SUCCESS;
        }catch(NotFoundException ex){
            code = "1001";
            return  ERROR;
        }catch(LockedException ex){
            code = "1002";
            return "locked";
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
