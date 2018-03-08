package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
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
            User user = (User) ActionContext.getContext().getSession().get("user");
            String groupId = user.getGroupId();
            TaskFormData taskFormData = formService.getTaskFormData(taskId);
            List<FormProperty> formProperties = taskFormData.getFormProperties();
            Map<String ,String> formValues = new HashMap<String, String>();
            for (FormProperty property : formProperties){
                if("user".equals(groupId) && property.getId().equals("reApply")){
                    formValues.put(property.getId(),approved);
                } else if("deptLeader".equals(groupId) && property.getId().equals("deptLeaderApproved")){
                    formValues.put(property.getId(),approved);
                } else  if("hr".equals(groupId) && property.getId().equals("hrApproved")){
                    formValues.put(property.getId(),approved);
                } else if(property.isWritable()){
                    formValues.put(property.getId(),property.getValue());
                }
            }
            for(Map.Entry<String,String> map : formValues.entrySet()){
                System.out.println("key:"+map.getKey()+"--------value:"+map.getValue());
            }
            formService.submitTaskFormData(taskId,formValues);
        }
        return "success";
    }
}
