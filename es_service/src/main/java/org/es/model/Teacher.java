package org.es.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;

public class Teacher implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jobno;

    private String tname;
    
    private String college;



	private String phone;

    private String email;

    private Integer gender;

    private String nativeplace;
    @JSONField(format="yyyy-MM-dd")
    private Date entrytime;

    private Integer maritalstatus;
    @JSONField(format="yyyy-MM-dd")
    private Date birthdate;

    private String maxdegree;

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno == null ? null : jobno.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNativeplace() {
        return nativeplace;
    }
    public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Integer getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(Integer maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMaxdegree() {
        return maxdegree;
    }

    public void setMaxdegree(String maxdegree) {
        this.maxdegree = maxdegree == null ? null : maxdegree.trim();
    }
    
}