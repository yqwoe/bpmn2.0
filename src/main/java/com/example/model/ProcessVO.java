package com.example.model;

public class ProcessVO {
    String startDate;
    String endDate;
    String reason;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ProcessVO() {
    }

    public ProcessVO(String startDate, String endDate, String reason, String deptLeaderApproved, String hrApproved, String repoertBackDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.deptLeaderApproved = deptLeaderApproved;
        this.hrApproved = hrApproved;
        this.repoertBackDate = repoertBackDate;
    }

    public String getEndDate() {
        return endDate;

    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDeptLeaderApproved() {
        return deptLeaderApproved;
    }

    public void setDeptLeaderApproved(String deptLeaderApproved) {
        this.deptLeaderApproved = deptLeaderApproved;
    }

    public String getHrApproved() {
        return hrApproved;
    }

    public void setHrApproved(String hrApproved) {
        this.hrApproved = hrApproved;
    }

    public String getRepoertBackDate() {
        return repoertBackDate;
    }

    public void setRepoertBackDate(String repoertBackDate) {
        this.repoertBackDate = repoertBackDate;
    }

    String deptLeaderApproved;
    String hrApproved;
    String repoertBackDate;

}
