package org.es.model;

import org.es.util.excelutil.OutName;

public class Schedule {
    private String scheNo;
    private Integer mark;
	@OutName("课程号")
    private String courseNo;
	@OutName("工号")
    private String jobno;
	@OutName("上课地点")
    private String place;
	@OutName("开始周")
    private Integer startWeek;
	@OutName("结束周")
    private Integer endWeek;
	@OutName("容量")
    private Integer capacity;
	@OutName("剩余容量")
    private Integer margin;
	@OutName("学年")
    private String yeartime;
	@OutName("学期")
    private Integer termtime;
	@OutName("面向年级")
    private String grade;
	@OutName("周几")
    private Integer weekno;
	@OutName("第几节")
    private String jie;
	@OutName("面向学院")
    private String college;
	@OutName("面向专业")
    private String specialty;
	@OutName("面向班级")
    private String classno;
    private String sno;
    
    

    public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getScheNo() {
        return scheNo;
    }

    public void setScheNo(String scheNo) {
        this.scheNo = scheNo == null ? null : scheNo.trim();
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno == null ? null : jobno.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getWeekno() {
        return weekno;
    }

    public void setWeekno(Integer weekno) {
        this.weekno = weekno;
    }

    public String getJie() {
        return jie;
    }

    public void setJie(String jie) {
        this.jie = jie == null ? null : jie.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno == null ? null : classno.trim();
    }
}