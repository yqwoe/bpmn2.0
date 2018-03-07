package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;

import java.util.List;

public class DeptLeaderAction extends ActionSupport {
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
        String type = "";
        if("1".equals(reuquestType)){
            type = "deptLeader";
            title = "总经理审批";
        }else if("2".equals(reuquestType)){
            type = "hr";
            title = "人事审批";
        }else{
            type = "user";
            title = "请假申请";
        }
        tasks = taskService.createTaskQuery().taskCandidateGroup(type).list();
        for(Task task : tasks){
            task.getDelegationState();
            System.out.println("taskName:"+task.getName()+"----------taskGroup:"+task.getCreateTime());
        }
        return "success";
    }
}
