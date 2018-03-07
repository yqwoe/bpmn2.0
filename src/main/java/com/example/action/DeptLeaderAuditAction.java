package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.FormService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptLeaderAuditAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    TaskService taskService;

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    FormService formService;

    public FormService getFormService() {
        return formService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    String approved;

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String execute(){
        if(taskId != null){

            System.out.printf("approved"+approved);
            TaskFormData taskFormData = formService.getTaskFormData(taskId);
            List<FormProperty> formProperties = taskFormData.getFormProperties();
            Map<String ,String> formValues = new HashMap<String, String>();
            for (FormProperty property : formProperties){
                if(property.isWritable()){
                    formValues.put(property.getId(),approved);
                }
            }

            formService.submitTaskFormData(taskId,formValues);
        }
        return "success";
    }
}
