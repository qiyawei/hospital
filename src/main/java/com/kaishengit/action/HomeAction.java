package com.kaishengit.action;

import org.apache.struts2.convention.annotation.Action;

import javax.inject.Named;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
public class HomeAction extends BaseAction {



    @Action("/index")
    @Override
    public String execute() throws Exception {
       return SUCCESS;
    }


    public String login(){
        return NONE;
    }
}
