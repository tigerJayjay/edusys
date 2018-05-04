package org.es.model;

import java.util.Date;

public class AdminOffice {
    private String officeNo;

    private String name;

    private String des;

    private Date buildtime;

    private String leaderNo;

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo == null ? null : officeNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public String getLeaderNo() {
        return leaderNo;
    }

    public void setLeaderNo(String leaderNo) {
        this.leaderNo = leaderNo == null ? null : leaderNo.trim();
    }
}