package org.es.service.manager.student;

import java.util.Date;

public class StudentQueryCondition {
	private String sno;

    private String sname;

    private String entranceTimeStart;
    
    private String entranceTimeEnd;

    private Integer grade;

    private Integer classname;

    private String college;

    private Integer gender;

    private String birthdateStart;
   
    private String birthdateEnd;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEntranceTimeStart() {
		return entranceTimeStart;
	}

	public void setEntranceTimeStart(String entranceTimeStart) {
		this.entranceTimeStart = entranceTimeStart;
	}

	public String getEntranceTimeEnd() {
		return entranceTimeEnd;
	}

	public void setEntranceTimeEnd(String entranceTimeEnd) {
		this.entranceTimeEnd = entranceTimeEnd;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getClassname() {
		return classname;
	}

	public void setClassname(Integer classname) {
		this.classname = classname;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthdateStart() {
		return birthdateStart;
	}

	public void setBirthdateStart(String birthdateStart) {
		this.birthdateStart = birthdateStart;
	}

	public String getBirthdateEnd() {
		return birthdateEnd;
	}

	public void setBirthdateEnd(String birthdateEnd) {
		this.birthdateEnd = birthdateEnd;
	}

	
    
}
