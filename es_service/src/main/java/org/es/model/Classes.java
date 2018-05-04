package org.es.model;

import java.util.Date;

public class Classes {
    private String classNo;

    private String speNo;

    private String specialty;

    private Date buildtime;

    private Integer stucount;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    public String getSpeNo() {
        return speNo;
    }

    public void setSpeNo(String speNo) {
        this.speNo = speNo == null ? null : speNo.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getStucount() {
        return stucount;
    }

    public void setStucount(Integer stucount) {
        this.stucount = stucount;
    }
}