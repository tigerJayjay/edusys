package org.es.model;

import java.util.Date;

public class Degree {
    private Integer no;

    private Integer workerNo;

    private String graduationschool;

    private Date graduatiointime;

    private String degree;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getWorkerNo() {
        return workerNo;
    }

    public void setWorkerNo(Integer workerNo) {
        this.workerNo = workerNo;
    }

    public String getGraduationschool() {
        return graduationschool;
    }

    public void setGraduationschool(String graduationschool) {
        this.graduationschool = graduationschool == null ? null : graduationschool.trim();
    }

    public Date getGraduatiointime() {
        return graduatiointime;
    }

    public void setGraduatiointime(Date graduatiointime) {
        this.graduatiointime = graduatiointime;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }
}