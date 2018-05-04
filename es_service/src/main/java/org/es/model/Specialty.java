package org.es.model;

import java.util.Date;

public class Specialty {
    private String speNo;

    private String colNo;

    private String speName;

    private Date starttime;

    private String college;

    private Integer lenSchool;

    public String getSpeNo() {
        return speNo;
    }

    public void setSpeNo(String speNo) {
        this.speNo = speNo == null ? null : speNo.trim();
    }

    public String getColNo() {
        return colNo;
    }

    public void setColNo(String colNo) {
        this.colNo = colNo == null ? null : colNo.trim();
    }

    public String getSpeName() {
        return speName;
    }

    public void setSpeName(String speName) {
        this.speName = speName == null ? null : speName.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public Integer getLenSchool() {
        return lenSchool;
    }

    public void setLenSchool(Integer lenSchool) {
        this.lenSchool = lenSchool;
    }
}