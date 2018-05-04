package org.es.model;

public class Invigilate {
    private Integer no;

    private String jobno;

    private Integer examno;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno == null ? null : jobno.trim();
    }

    public Integer getExamno() {
        return examno;
    }

    public void setExamno(Integer examno) {
        this.examno = examno;
    }
}