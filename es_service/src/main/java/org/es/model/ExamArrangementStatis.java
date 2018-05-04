package org.es.model;

public class ExamArrangementStatis {
    private Integer no;

    private String courseNo;

    private Integer termtime;

    private String yeartime;

    private Integer weekth;

    private Integer weekno;

    private String schooltime;

    private String examPlace;

    private String college;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
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

    public Integer getWeekth() {
        return weekth;
    }

    public void setWeekth(Integer weekth) {
        this.weekth = weekth;
    }

    public Integer getWeekno() {
        return weekno;
    }

    public void setWeekno(Integer weekno) {
        this.weekno = weekno;
    }

    public String getSchooltime() {
        return schooltime;
    }

    public void setSchooltime(String schooltime) {
        this.schooltime = schooltime == null ? null : schooltime.trim();
    }

    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace == null ? null : examPlace.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }
}