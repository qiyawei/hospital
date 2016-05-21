package com.kaishengit.service;

import com.kaishengit.dao.InsurDao;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Insurance;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/21.
 */
@Named
@Transactional
public class InsurService {
    @Inject
    private InsurDao insurDao;


    public List<Insurance> findAll() {
        return insurDao.findAll();
    }


    public void save(Insurance insurance) {
        insurDao.save(insurance);
    }

    public Insurance findById(Integer id) {
        Insurance insurance = insurDao.findById(id);
        if(insurance == null){
            throw new NotFoundException("");
        }
        return insurance;
    }

    public void update(Insurance insurance) {
        insurDao.save(insurance);
    }

    public void del(Integer id) {
        Insurance insurance = insurDao.findById(id);
        if(insurance == null){
            throw new NotFoundException("");
        }

        insurDao.del(insurance);
    }
}
