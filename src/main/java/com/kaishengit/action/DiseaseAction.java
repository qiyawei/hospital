package com.kaishengit.action;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/20.
 */
@Namespace("/disease")
public class DiseaseAction extends BaseAction {
    @Inject
    private DiseaseService diseaseService;

    @Inject
    private DeptService deptService;

    private Disease disease;
    private Integer id;
    private String pageNo;
    private Page<Disease> page;
    private List<Dept> deptList;

    @Action(value = "list")
    @Override
    public String execute() throws Exception {

        HttpServletRequest request = getHttpRequest();
        List<SearchFilter> searchFilterList = SearchFilter.builderSearchFilter(request);
        page = diseaseService.findAllByParamAndPage(pageNo,searchFilterList);
        deptList = deptService.findAll();
        return SUCCESS;
    }
    @Action("new")
    public String newDept(){
        deptList = deptService.findAll();
        return SUCCESS;
    }


    @Action(value = "save",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list","namespace","/disease"
            })
    })
    public String save(){
        diseaseService.save(disease);
        return SUCCESS;
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String del(){
        diseaseService.del(id);
        return SUCCESS;
    }
    @Action("edit")
    public String edit(){
        deptList = deptService.findAll();
        disease = diseaseService.findById(id);
        return SUCCESS;
    }

    @Action(value = "update",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String update(){
        diseaseService.update(disease);
        return SUCCESS;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public Page<Disease> getPage() {
        return page;
    }

    public void setPage(Page<Disease> page) {
        this.page = page;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }
}
