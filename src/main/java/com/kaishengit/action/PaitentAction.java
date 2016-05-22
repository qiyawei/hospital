package com.kaishengit.action;

import com.kaishengit.pojo.Insurance;
import com.kaishengit.pojo.Paitent;
import com.kaishengit.service.InsurService;
import com.kaishengit.service.PaitentService;
import com.kaishengit.util.Page;
import com.kaishengit.util.SearchFilter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by qiyawei on 2016/5/21.
 */
@Namespace("/paitent")
public class PaitentAction extends BaseAction{
    @Inject
    private PaitentService paitentService;
    @Inject
    private InsurService insurService;
    private Page<Paitent> page;
    private String pageNo;
    private List<Insurance> insuranceList;
    private Paitent paitent;
    private Integer id;
    @Action("list")
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = getHttpRequest();
        List<SearchFilter> searchFilterList = SearchFilter.builderSearchFilter(request);
        page = paitentService.findByPage(pageNo,searchFilterList);
        return SUCCESS;
    }
    @Action("new")
    public String newPaitent(){
        insuranceList = insurService.findAll();
        return SUCCESS;
    }

    @Action(value = "save",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String save(){
       paitentService.save(paitent);
        return SUCCESS;
    }
    @Action("view")
    public String view(){
        paitent = paitentService.findById(id);
        return SUCCESS;
    }
    @Action("edit")
    public String edit(){
        insuranceList = insurService.findAll();
        paitent = paitentService.findById(id);
        return SUCCESS;
    }
    @Action(value = "update",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","view","id","${id}"
            })
    })
    public String update(){
        id = paitent.getId();
        System.out.println(paitent.getSex());
        paitentService.update(paitent);
        return SUCCESS;
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {
                    "actionName","list"
            })
    })
    public String del(){
        paitentService.del(id);
        return SUCCESS;
    }
    //get set


    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public Page<Paitent> getPage() {
        return page;
    }

    public void setPage(Page<Paitent> page) {
        this.page = page;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public Paitent getPaitent() {
        return paitent;
    }

    public void setPaitent(Paitent paitent) {
        this.paitent = paitent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
