package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZhangSer on 2016/5/22.
 */
@Entity
@Table(name = "t_visit")
public class Visit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String chuzhen;
    private String zhengzhuang;
    private String bingshi;
    private String tizheng;
    private String jieguo;
    private String fangan;
    private String peihu;
    private String createtime;
    private String nexttime;
    private String path;

    @ManyToOne
    @JoinColumn(name = "paitentId")
    private Paitent paitent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId")
    private Dept dept;

    @ManyToOne
    @JoinColumn(name = "diseaseId")
    private Disease disease;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChuzhen() {
        return chuzhen;
    }

    public void setChuzhen(String chuzhen) {
        this.chuzhen = chuzhen;
    }

    public String getZhengzhuang() {
        return zhengzhuang;
    }

    public void setZhengzhuang(String zhengzhuang) {
        this.zhengzhuang = zhengzhuang;
    }

    public String getBingshi() {
        return bingshi;
    }

    public void setBingshi(String bingshi) {
        this.bingshi = bingshi;
    }

    public String getTizheng() {
        return tizheng;
    }

    public void setTizheng(String tizheng) {
        this.tizheng = tizheng;
    }

    public String getJieguo() {
        return jieguo;
    }

    public void setJieguo(String jieguo) {
        this.jieguo = jieguo;
    }

    public String getFangan() {
        return fangan;
    }

    public void setFangan(String fangan) {
        this.fangan = fangan;
    }

    public String getPeihu() {
        return peihu;
    }

    public void setPeihu(String peihu) {
        this.peihu = peihu;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getNexttime() {
        return nexttime;
    }

    public void setNexttime(String nexttime) {
        this.nexttime = nexttime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Paitent getPaitent() {
        return paitent;
    }

    public void setPaitent(Paitent paitent) {
        this.paitent = paitent;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}

