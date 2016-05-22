package com.kaishengit.service;

import com.kaishengit.dao.PaitentDao;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Paitent;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.apache.struts2.convention.annotation.Action;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/21.
 */
@Named
@Transactional
public class PaitentService {
    @Inject
    private PaitentDao paitentDao;

    public Page<Paitent> findByPage(String pageNo, List<SearchFilter> searchFilterList) {
        return paitentDao.findPage(pageNo,3,searchFilterList);
    }

    public void save(Paitent paitent) {
        paitent.setState("在诊");
        paitent.setCreatetime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        paitentDao.save(paitent);
    }

    public Paitent findById(Integer id) {
        Paitent paitent = paitentDao.findById(id);
        if(paitent == null){
            throw new NotFoundException("您要查看的病人信息不存在");
        }
        return paitent;
    }

    public void update(Paitent paitent) {
        paitentDao.save(paitent);
    }


    public void del(Integer id) {
        Paitent paitent = paitentDao.findById(id);
        if(paitent == null){
            throw new NotFoundException("您要查看的病人信息不存在");
        }
        paitentDao.del(paitent);
    }

    public Paitent findByName(String name) {
        return paitentDao.findByProperty("name",name);
    }
}
