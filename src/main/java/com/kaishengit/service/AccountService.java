package com.kaishengit.service;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.dao.RoleDao;
import com.kaishengit.exception.LockedException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Role;
import com.kaishengit.util.Page;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
@Transactional
public class AccountService {
    @Inject
    private AccountDao accountDao;
    @Inject
    private RoleDao roleDao;

    /**
     * 用户登录
     * @param loginName
     * @param password
     * @return
     */
    public Account findUserByName(String loginName, String password,String ip) {
        Account account = accountDao.findByProperty("loginName",loginName);
        if(account != null){
            System.out.println(111);
            //判断账号的状态
           if("禁用".equals(account.getState())){
               throw  new LockedException();
           }else{
               //判断密码是否指正确
               String passwordSalt = DigestUtils.md5Hex(password);
               if(account.getPassword().equals(passwordSalt)){
                   account.setLoginIp(ip);
                   account.setLogintime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
                   return account;
               }else {
                   throw new NotFoundException();
               }
           }
        }else{
            throw new NotFoundException();
        }

    }


    public Page<Account> findAllByPage(String pageNo) {
        Page<Account> page = accountDao.findPage(pageNo,5);
        return page;
    }

    public void save(Account account) {
        account.setCreatetime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        account.setState(Account.USER_STATE_OK);
        accountDao.save(account);
    }

    public void del(Integer id) {
        Account account = accountDao.findById(id);
        if(account == null){
            throw new NotFoundException("您要删除的账号不存在");
        }
        accountDao.del(account);
    }

    public Account findById(Integer id) {
        Account account = accountDao.findById(id);
        if(account == null){
            throw new NotFoundException("您要删除的账号不存在");
        }
        return account;
    }

    public List<Role> findAllRole() {
        return roleDao.findAll();
    }
}
