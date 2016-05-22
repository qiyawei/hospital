package com.kaishengit.service;

import com.kaishengit.dao.VisitDao;
import com.kaishengit.pojo.Paitent;
import com.kaishengit.pojo.Visit;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ZhangSer on 2016/5/22.
 */
@Named
@Transactional
public class VisitService{
    @Inject
    private VisitDao visitDao;
    public Page<Visit> findAllByPage(String pageNo, List<SearchFilter> searchFilterList) {
        return visitDao.findPage(pageNo,3,searchFilterList);
    }

    public void save(Visit visit) {
        visit.setCreatetime(DateTime.now().toString("yyyy-MM-dd"));
        visitDao.save(visit);
    }
}
