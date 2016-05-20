package com.kaishengit.action;

import com.kaishengit.exception.LockedException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;
import com.kaishengit.util.Message;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by qiyawei on 2016/5/20.
 */

public class HomeAction extends BaseAction {

    private String loginName;
    private String password;
    private String code;
    private String state;

    @Inject
    private AccountService accountService;


    @Action("/index")
    @Override
    public String execute() throws Exception {
       return SUCCESS;
    }

    @Action(value = "/home",results={
        @Result(name = "error",type = "redirectAction",params = {
                "actionName","index","namespace","/","code","${code}","state","${state}"
        }),
        @Result(name = "locked",type = "redirectAction",params = {
                "actionName","index","namespace","/","code","${code}","state","${state}"
        })
    })
    public String login(){
        try {
            HttpServletRequest request = getHttpRequest();
            String ip = request.getRemoteAddr();
            HttpSession session = request.getSession();

            Account account = accountService.findUserByName(loginName,password,ip);
            session.setAttribute(Account.SESSION_KEY,account);
            return SUCCESS;
        }catch(NotFoundException ex){
            code = "1001";
            state = Message.ERROR;
            return  ERROR;
        }catch(LockedException ex){
            code = "1002";
            state = Message.ERROR;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
