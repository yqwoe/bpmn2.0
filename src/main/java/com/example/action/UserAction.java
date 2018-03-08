package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import java.util.Map;


public class UserAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());
    String name;
    String password;

    public String getName() {
        return name;
}

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    IdentityService identityService;

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }


    public String execute(){
        System.out.printf("name:"+getName()+"-----------password:"+getPassword());
        ActionContext atx=ActionContext.getContext();
        String method = ServletActionContext.getRequest().getMethod();
        if("GET".equals(method))
            return "error";

        if(identityService.checkPassword(getName(),getPassword())){

            User user = new User(getName(),getPassword());
            //根绝用户id获取group
            Group group = identityService.createGroupQuery().groupMember(user.getName()).singleResult();
            user.setGroupId(group.getId());
            atx.getSession().put("user",user);
            return "success";
        }else{
            atx.getSession().put("user",null);
            return "error";
        }
    }
}
