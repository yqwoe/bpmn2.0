package com.example.action;

import com.example.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

public class HomeAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    public String execute(){
        ActionContext atx=ActionContext.getContext();
        User user = (User)atx.getSession().get("user");
        if(user != null)
            return "success";
        else
            return "error";
    }
}
