package org.es.model;

import org.es.util.excelutil.OutName;

public class ScoreInfo {
    private Integer no;
	@OutName("卷面分")
    private Double paperScore;
	@OutName("平时分")
    private Double maniScore;
	@OutName("总分")
    private Double totalScore;
    private Integer examStatus;
    @OutName("补考")
    private Double reexam;
    @OutName("重修")
    private Double rebuild;
    @OutName("课程号")
    private String courseno;
    @OutName("学号")
    private String sno;
    @OutName("学期")
    private Integer termtime;
    @OutName("学年")
    private String yeartime;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Double getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Double paperScore) {
        this.paperScore = paperScore;
    }

    public Double getManiScore() {
        return maniScore;
    }

    public void setManiScore(Double maniScore) {
        this.maniScore = maniScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public Double getReexam() {
        return reexam;
    }

    public void setReexam(Double reexam) {
        this.reexam = reexam;
    }

    public Double getRebuild() {
        return rebuild;
    }

    public void setRebuild(Double rebuild) {
        this.rebuild = rebuild;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno == null ? null : courseno.trim();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
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