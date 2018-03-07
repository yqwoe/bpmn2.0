package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

public class WelcomeAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    public String execute(){
            return "success";
    }
}
