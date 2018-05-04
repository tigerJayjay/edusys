package org.es.model;

public class TeacherCourse {
    private Integer no;

    private String sno;

    private String courseno;

    private Integer termtime;

    private String yeartime;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno == null ? null : courseno.trim();
    }

    public Integer getTermtime() {
        return termtime;
    }

    public void setTermtime(Integer termtime) {
        this.termtime = termtime;
    }

    public String getYeartime() {
        return yeartime;
    }

    public void setYeartime(String yeartime) {
        this.yeartime = yeartime == null ? null : yeartime.trim();
    }
}