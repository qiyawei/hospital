package com.kaishengit.service;

import com.kaishengit.dao.DiseaseDao;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Disease;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
@Transactional
public class DiseaseService {
    @Inject
    private DiseaseDao diseaseDao;


    public void save(Disease disease) {
        diseaseDao.save(disease);
    }

    public void del(Integer id) {
        Disease disease = diseaseDao.findById(id);
        if(disease == null){
            throw new NotFoundException("您要删除的病种不存在");
        }

        diseaseDao.del(disease);
    }

    public Disease findById(Integer id) {
        Disease disease = diseaseDao.findById(id);
        if(disease == null){
            throw new NotFoundException("您要修改的病种不存在");
        }

        return disease;
    }

    public void update(Disease disease) {
        diseaseDao.save(disease);
    }


    public Page<Disease> findAllByParamAndPage(String pageNo, List<SearchFilter> searchFilterList) {

        return diseaseDao.findPage(pageNo,3,searchFilterList);
    }
}
