package org.es.service.manager.exam;

/**
 * 监考安排查询条件
 * 
 * @author Administrator
 *
 */
public class InvigilateQueryCondition {
	// 教师工号
	private String tno;
	private String courseno;
	private Integer college;
	private String yeartime;
	private Integer termtime;

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getCourseno() {
		return courseno;
	}

	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}

	public Integer getCollege() {
		return college;
	}

	public void setCollege(Integer college) {
		this.college = college;
	}

	public String getYeartime() {
		return yeartime;
	}

	public void setYeartime(String yeartime) {
		this.yeartime = yeartime;
	}

	public Integer getTermtime() {
		return termtime;
	}

	public void setTermtime(Integer termtime) {
		this.termtime = termtime;
	}

}
