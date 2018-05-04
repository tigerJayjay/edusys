package org.es.service.manager.teacher;

import java.util.Date;

/**
 * 教师查询条件
 * @author Administrator
 *
 */
public class TeacherQueryCondition {
	    
	    private String jobno;

	    private String tname;

	    private String college;

	    private Integer gender;

        
	    private Date entrytimeStart;
	    
	    private Date entrytimeEnd;

	    private Integer maritalstatus;//0未婚 1已婚

		public String getJobno() {
			return jobno;
		}

		public void setJobno(String jobno) {
			this.jobno = jobno;
		}

		public String getTname() {
			return tname;
		}

		public void setTname(String tname) {
			this.tname = tname;
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

		public Date getEntrytimeStart() {
			return entrytimeStart;
		}

		public void setEntrytimeStart(Date entrytimeStart) {
			this.entrytimeStart = entrytimeStart;
		}

		public Date getEntrytimeEnd() {
			return entrytimeEnd;
		}

		public void setEntrytimeEnd(Date entrytimeEnd) {
			this.entrytimeEnd = entrytimeEnd;
		}

		public Integer getMaritalstatus() {
			return maritalstatus;
		}

		public void setMaritalstatus(Integer maritalstatus) {
			this.maritalstatus = maritalstatus;
		}
	    
	    

}
