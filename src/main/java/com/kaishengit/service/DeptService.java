package com.kaishengit.service;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.exception.NotFoundException;
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

    public void del(Integer id) {
        Dept dept = deptDao.findById(id);
        if(dept == null){
            throw new NotFoundException("您要删除的科室不存在");
        }

        deptDao.del(dept);
    }

    public Dept findById(Integer id) {
        Dept dept = deptDao.findById(id);
        if(dept == null){
            throw new NotFoundException("您要修改的科室不存在");
        }else{
            return dept;
        }
    }

    public void update(Dept dept) {
        deptDao.save(dept);
    }
}
