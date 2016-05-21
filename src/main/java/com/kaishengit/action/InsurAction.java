package com.kaishengit.action;

import com.kaishengit.pojo.Insurance;
import com.kaishengit.service.InsurService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/21.
 */
@Namespace("/insur")
public class InsurAction extends BaseAction {
    @Inject
    private InsurService insurService;
    private Integer id;
    private List<Insurance> insuranceList;
    private Insurance insurance;

    @Action(value = "list")
    @Override
    public String execute() throws Exception {
        insuranceList = insurService.findAll();
        return SUCCESS;
    }

    @Action("new")
    public String newInsur(){
       return SUCCESS;
    }

    @Action(value = "save",results = {
            @Result(name = "success",type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String save(){
        insurService.save(insurance);
        return SUCCESS;
    }

    @Action("edit")
    public String edit(){

        insurance = insurService.findById(id);
        return SUCCESS;
    }

    @Action(value = "update",results = {
            @Result(name = "success",type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String update(){
        insurService.update(insurance);
        return SUCCESS;
    }


    @Action(value = "del",results = {
            @Result(name = "success",type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String del(){
        insurService.del(id);
        return SUCCESS;
    }



    //get set
    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
