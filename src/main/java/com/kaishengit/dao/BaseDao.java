package com.kaishengit.dao;

import com.kaishengit.pojo.Disease;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<T,PK extends Serializable> {

    @Inject
    private SessionFactory sessionFactory;
    private Class<?> clazz;

    public BaseDao() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<?>) type.getActualTypeArguments()[0];
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Criteria getCriteria(){
        return getSession().createCriteria(clazz);
    }
    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public T findById(PK id) {
        return (T) getSession().get(clazz,id);
    }

    public void del(PK id) {
        getSession().delete(findById(id));
    }

    public void del(T entity) {
        getSession().delete(entity);
    }

    public List<T> findAll() {
        Criteria criteria = getCriteria();
        return criteria.list();
    }

    public List<T> findByPage(Integer start,Integer end) {
        Criteria criteria = getCriteria();
        criteria.setFirstResult(start);
        criteria.setMaxResults(end);
        return criteria.list();
    }

    public Page<T> findPage(String pageNo,Integer pageSize) {
        int count = count().intValue();
        Page<T> page = new Page<T>(pageNo,count,pageSize);
        page.setItems(findByPage(page.getStart(),page.getSize()));
        return page;
    }


    public List<T> findBySearchFilter(List<SearchFilter> searchFilters) {
        Criteria criteria = getCriteriaBySearchFilter(searchFilters);
        return criteria.list();
    }

    public Page<T> findPage(String pageNo,Integer pageSize,List<SearchFilter> searchFilters) {
        Criteria criteria = getCriteriaBySearchFilter(searchFilters);

        int count = countUseCriteria(criteria).intValue();

        Page<T> page = new Page<T>(pageNo,count,pageSize);
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getSize());
        page.setItems(criteria.list());
        return page;
    }

    private Long countUseCriteria(Criteria criteria) {
        ResultTransformer resultTransformer = criteria.ROOT_ENTITY;

        criteria.setProjection(Projections.rowCount());
        long rowCount = (long) criteria.uniqueResult();
        criteria.setProjection(null);
        criteria.setResultTransformer(resultTransformer);

       // http://localhost/disease/list.do?q_i_eq_type.id=1
        return rowCount;
    }

    private Criteria getCriteriaBySearchFilter(List<SearchFilter> searchFilters) {
        Criteria criteria = getCriteria();
        for(SearchFilter searchFilter : searchFilters) {
            String propertyName = searchFilter.getPropertyName();
            String equalType = searchFilter.getEqualType();
            Object value = searchFilter.getValue();
            if(propertyName.contains("_or_")) {
                String[] names = propertyName.split("_or_");

                Disjunction disjunction = Restrictions.disjunction();
                for(String name : names) {
                    Criterion criterion = buildWhereCondition(name,equalType,value);
                    disjunction.add(criterion);
                }

                criteria.add(disjunction);
            } else {
                criteria.add(buildWhereCondition(propertyName,equalType,value));
            }
        }
        return criteria;
    }

    private Criterion buildWhereCondition(String propertyName, String equalType, Object value) {
        if("eq".equalsIgnoreCase(equalType)) {
            return Restrictions.eq(propertyName,value);
        } else if("like".equalsIgnoreCase(equalType)) {
            return Restrictions.like(propertyName,value.toString(), MatchMode.ANYWHERE);
        } else if("gt".equals(equalType)) {
            return Restrictions.gt(propertyName,value);
        } else if("lt".equals(equalType)) {
            return Restrictions.lt(propertyName,value);
        } else if("ge".equals(equalType)) {
            return Restrictions.ge(propertyName,value);
        } else if("le".equals(equalType)) {
            return Restrictions.le(propertyName,value);
        }
        return null;
    }


    public List<T> findAllOrder(String orderPropertyName,String orderType) {
        Criteria criteria = getCriteria();
        if("desc".equalsIgnoreCase(orderType)) {
            criteria.addOrder(Order.desc(orderPropertyName));
        } else {
            criteria.addOrder(Order.asc(orderPropertyName));
        }
        return criteria.list();
    }

    public T findByProperty(String propertyName,Object value) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq(propertyName,value));
        return (T) criteria.uniqueResult();
    }

    public List<T> findListByProperty(String propertyName,Object value) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq(propertyName,value));
        return criteria.list();
    }

    public Long count() {
        Criteria criteria = getCriteria();
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }


}
