package com.kaishengit.dao;

import com.kaishengit.pojo.Disease;
import org.hibernate.Criteria;

import javax.inject.Named;
/**
 * Created by qiyawei on 2016/5/20.
 */
@Named
public class DiseaseDao extends BaseDao<Disease,Integer> {

        @Override
        public Criteria getCriteria() {
            Criteria criteria = getSession().createCriteria(Disease.class);
            criteria.createAlias("dept","type");
            return criteria;
        }

}
