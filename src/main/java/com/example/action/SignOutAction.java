package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.IdentityService;
import org.apache.log4j.Logger;

public class SignOutAction  extends ActionSupport {
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
        User user = (User)atx.getSession().get("user");
        if(user != null){
            atx.getSession().remove("user");
        }
        return "success";
    }
}
