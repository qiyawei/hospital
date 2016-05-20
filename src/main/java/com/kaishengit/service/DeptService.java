package com.kaishengit.service;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.pojo.Dept;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
@Transactional
public class DeptService {
    @Inject
    private DeptDao deptDao;
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public void save(Dept dept) {
        deptDao.save(dept);
    }
}
