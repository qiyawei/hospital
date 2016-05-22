package com.kaishengit.action;

import com.google.gson.Gson;
import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.pojo.Paitent;
import com.kaishengit.pojo.Visit;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import com.kaishengit.service.PaitentService;
import com.kaishengit.service.VisitService;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import com.kaishengit.util.UploadQiniuUtil;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ZhangSer on 2016/5/22.
 */
@Namespace("/visit")
public class VisitAction extends BaseAction{
    @Inject
    private VisitService visitService;
    @Inject
    private DeptService deptService;
    @Inject
    private DiseaseService diseaseService;
    @Inject
    private PaitentService paitentService;
    private Page<Visit> page;
    private Integer id;
    private List<Dept> deptList;
    private List<Disease> diseaseList;
    private Visit visit;
    private String pageNo;
    private Dept dept;
    private String token;
    private Paitent paitent;
    private String name;
    @Action("list")
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = getHttpRequest();
        List<SearchFilter> searchFilterList = SearchFilter.builderSearchFilter(request);
        page = visitService.findAllByPage(pageNo,searchFilterList);
        return SUCCESS;
    }

    @Action("new")
    public String newVisit(){
        token =new UploadQiniuUtil().upload();
        deptList = deptService.findAll();
        return SUCCESS;
    }

   @Action(value = "dept",results = {
            @Result(type = "json",params = {
                "root","dept","noCache","true","enableGZIP","true","excludeNullProperties","true"
            })
    })
    public String deptJson() throws IOException {
        dept = deptService.findById(id);
        return SUCCESS;
    }

    @Action(value = "paitent",results = {
            @Result(type = "json",params = {
                    "root","paitent","noCache","true","enableGZIP","true","excludeNullProperties","true"
            })
    })
    public String paitentJson(){
        paitent = paitentService.findByName(name);
        return SUCCESS;
    }
    @Action(value = "save",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String save(){
        visitService.save(visit);
        return SUCCESS;
    }


    //get set


    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public Page<Visit> getPage() {
        return page;
    }

    public void setPage(Page<Visit> page) {
        this.page = page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Paitent getPaitent() {
        return paitent;
    }

    public void setPaitent(Paitent paitent) {
        this.paitent = paitent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
