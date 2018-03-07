package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaveAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    Date startDate;
    Date endDate;
    String reason;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    RepositoryService repositoryService;

    IdentityService identityService;

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    FormService formService;

    public FormService getFormService() {
        return formService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    public String execute(){
        //请假申请提交
        System.out.printf("startDate:"+getStartDate()+"----------endDate:"+getEndDate()+"-------------reason:"+getReason());

        if(startDate == null || endDate == null || reason == null)
            return "error";
        User user = (User)ActionContext.getContext().getSession().get("user");
        identityService.setAuthenticatedUserId(user.getName());

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("leave").singleResult();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("startDate",formatDate(startDate));
        vars.put("endDate", formatDate(endDate));
        vars.put("reason", reason);
        // 启动流程实例
        ProcessInstance processInstance = formService.submitStartFormData(processDefinition.getId(),vars);

        return "success";
    }

    String formatDate(Date d){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = sdf.format(new Date());
            return dateString;
        }catch (Exception e){
            return "";
        }
    }
}
