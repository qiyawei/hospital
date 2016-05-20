package com.kaishengit.action;

import com.kaishengit.pojo.Dept;
import com.kaishengit.service.DeptService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Namespace("/dept")
public class DeptAction extends BaseAction{

    @Inject
    private DeptService deptService;

    private List<Dept> deptList;
    private Dept dept;
    private Integer id;


    @Action(value = "list")
    @Override
    public String execute() throws Exception {
        deptList = deptService.findAll();
        return SUCCESS;
    }
    @Action("new")
    public String newDept(){
        return SUCCESS;
    }


    @Action(value = "save",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list","namespace","/dept"
            })
    })
    public String save(){
        deptService.save(dept);
        return SUCCESS;
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list","namespace","/dept"
            })
    })
    public String del(){
        deptService.del(id);
        return SUCCESS;
    }
    @Action("edit")
    public String edit(){
        dept = deptService.findById(id);
        return SUCCESS;
    }

    @Action(value = "update",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String update(){
        deptService.update(dept);
        return SUCCESS;
    }




    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
