package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReapplyAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    FormService formService;

    public FormService getFormService() {
        return formService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    TaskService taskService;

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
    String taskId;
    String approved;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String execute(){
        //请假申请重新提交
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        List<FormProperty> formProperties = taskFormData.getFormProperties();
        Map<String ,String> formValues = new HashMap<String, String>();
        for (FormProperty property : formProperties){
            if(property.getId().equals("reApply")){
                formValues.put(property.getId(),approved);
            } else if(property.isWritable()){
                formValues.put(property.getId(),property.getValue());
            }
        }

        formService.submitTaskFormData(taskId,formValues);

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

