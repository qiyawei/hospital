package com.kaishengit.action;

import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Role;
import com.kaishengit.service.AccountService;
import com.kaishengit.util.Page;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by qiyawei on 2016/5/20.
 */
@Namespace("/account")
public class AccountAction extends BaseAction {
    @Inject
    private AccountService accountService;

    private String pageNo;
    private Page<Account> page;
    private Account account;
    private Integer id;
    private List<Role> roleList;

    @Action("list")
    @Override
    public String execute() throws Exception {
        page = accountService.findAllByPage(pageNo);
        return SUCCESS;
    }

    @Action("new")
    public String newAccount(){
        return SUCCESS;
    }

    @Action(value = "save",results = {
            @Result(name = "success",type = "redirectAction",params = {
                    "actionName","list","namespace","/account"
            })
    })
    public String save(){
        accountService.save(account);
        return SUCCESS;
    }


    @Action(value = "del",results = {
            @Result(name = "success",type = "redirectAction",params = {
                    "actionName","list","namespace","/account"
            })
    })
    public String del(){
        accountService.del(id);
        return SUCCESS;
    }
    @Action("edit")
    public String edit(){
        account = accountService.findById(id);
        roleList = accountService.findAllRole();
        System.out.println(roleList.size());
        return SUCCESS;
    }



    @Action(value = "update",results = {
            @Result(name = "success",type = "redirectAction",params = {
                    "actionName","list","namespace","/account"
            })
    })
    public String update(){
        accountService.update(account);
        return SUCCESS;
    }
    @Action(value = "locked",results = {
            @Result(type = "redirectAction" ,params = {
                    "actionName","list"
            })
    })
    public String locked(){
        accountService.locked(id);
        return SUCCESS;
    }

    /**
     * get set 方法
     * @return
     */

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public Page<Account> getPage() {
        return page;
    }

    public void setPage(Page<Account> page) {
        this.page = page;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
