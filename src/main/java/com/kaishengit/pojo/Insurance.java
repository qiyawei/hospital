package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qiyawei on 2016/5/21.
 */
@Entity
@Table(name = "t_insurance")
public class Insurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String insurName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsurName() {
        return insurName;
    }

    public void setInsurName(String insurName) {
        this.insurName = insurName;
    }
}
