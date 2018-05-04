package org.es.service.manager.exam;
/**
 * 考试异常查询条件
 * @author Administrator
 *
 */
public class ExamAboQueryCondition {
	private String yeartime;
	private String termtime;
	private String courseNo;
	private String sno;
	protected String getYeartime() {
		return yeartime;
	}
	protected void setYeartime(String yeartime) {
		this.yeartime = yeartime;
	}
	

	public String getTermtime() {
		return termtime;
	}
	public void setTermtime(String termtime) {
		this.termtime = termtime;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	protected String getSno() {
		return sno;
	}
	protected void setSno(String sno) {
		this.sno = sno;
	}
	
}
