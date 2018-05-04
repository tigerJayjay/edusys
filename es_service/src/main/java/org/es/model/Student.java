package org.es.model;

import java.io.Serializable;
import java.util.Date;

import org.es.util.excelutil.OutName;

import com.alibaba.fastjson.annotation.JSONField;

public class Student implements Serializable{
	@OutName("学号")
    private String sno;
    @OutName("班级")
    private String classNo;
    @OutName("姓名")
    private String sname;
    @OutName("入学时间")
    private String entranceTime;
    @OutName("年级")
    private Integer grade;
    @OutName("专业")
    private Integer classname;
    @OutName("学院")
    private String college;
    @OutName("性别")
    private Integer gender;
    @OutName("生日")
    private String birthdate;
    @OutName("电话")
    private String phonenumber;
    @OutName("邮箱")
    private String email;
    @OutName("紧急联系人")
    private String emergency;
    @OutName("紧急联系人联系方式")
    private String emergencyphone;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime == null ? null : entranceTime.trim();
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
        this.college = college == null ? null : college.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }



    public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency == null ? null : emergency.trim();
    }

    public String getEmergencyphone() {
        return emergencyphone;
    }

    public void setEmergencyphone(String emergencyphone) {
        this.emergencyphone = emergencyphone == null ? null : emergencyphone.trim();
    }
}