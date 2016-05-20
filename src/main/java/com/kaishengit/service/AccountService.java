package com.kaishengit.service;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.exception.LockedException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Account;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
@Transactional
public class AccountService {
    @Inject
    private AccountDao accountDao;

    /**
     * 用户登录
     * @param loginName
     * @param password
     * @return
     */
    public Account findUserByName(String loginName, String password) {
        Account account = accountDao.findByProperty("loginName",loginName);
        if(account != null){
            //判断账号的状态
           if("正常".equals(account.getState())){
               throw  new LockedException();
           }else{
               //判断密码是否指正确
               if(account.getPassword().equals(password)){
                   return account;
               }else {
                   throw new NotFoundException();
               }
           }
        }else{
            return null;
        }

    }
}
