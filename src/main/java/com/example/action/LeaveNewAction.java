package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import java.util.Date;

public class LeaveNewAction extends ActionSupport {
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

    public String execute(){
        //请假申请提交
        return "success";
    }
}