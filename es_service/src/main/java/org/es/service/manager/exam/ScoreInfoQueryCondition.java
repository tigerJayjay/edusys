package org.es.service.manager.exam;
/**
 * 成绩查询条件
 * @author Administrator
 *
 */
public class ScoreInfoQueryCondition {
	private String yeartime;
	private Integer termtime;
	private String sno;
	private String tno;
	private String courseno;
	private Integer couseno;
	
	
	public Integer getCouseno() {
		return couseno;
	}
	public void setCouseno(Integer couseno) {
		this.couseno = couseno;
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
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
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
}
