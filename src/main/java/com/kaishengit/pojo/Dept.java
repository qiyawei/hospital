package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Entity
@Table(name = "t_dept")
public class Dept implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String deptName;
    private String manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
