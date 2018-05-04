package org.es.model;

public class ExamAbnormal {
    private Integer no;

    private String sno;

    private Integer statusno;

    private String recordno;

    private String recordtime;

    private String courseno;

    private String yeartime;

    private Integer termtime;

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

    public Integer getStatusno() {
        return statusno;
    }

    public void setStatusno(Integer statusno) {
        this.statusno = statusno;
    }

    public String getRecordno() {
        return recordno;
    }

    public void setRecordno(String recordno) {
        this.recordno = recordno == null ? null : recordno.trim();
    }

    public String getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(String recordtime) {
        this.recordtime = recordtime == null ? null : recordtime.trim();
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno == null ? null : courseno.trim();
    }

    public String getYeartime() {
        return yeartime;
    }

    public void setYeartime(String yeartime) {
        this.yeartime = yeartime == null ? null : yeartime.trim();
    }

    public Integer getTermtime() {
        return termtime;
    }

    public void setTermtime(Integer termtime) {
        this.termtime = termtime;
    }
}