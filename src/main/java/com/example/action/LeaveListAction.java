package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaveListAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    TaskService taskService;

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    String reuquestType;

    public String getReuquestType() {
        return reuquestType;
    }

    public void setReuquestType(String reuquestType) {
        this.reuquestType = reuquestType;
    }

    List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String execute(){
        System.out.printf("process execute");
        User user = (User) ActionContext.getContext().getSession().get("user");
        tasks = taskService.createTaskQuery().active().list();
        for(Task task : tasks){
            System.out.println("taskName:"+task.getName()+"----------taskGroup:"+task.getCreateTime());
        }
        return "success";
    }
}
