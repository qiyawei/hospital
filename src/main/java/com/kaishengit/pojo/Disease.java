package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Entity
@Table(name = "t_disease")
public class Disease implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String diseaseName;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Dept dept;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
