package org.es.service.manager.teacher;
/**
 * 考评信息查询条件
 * @author Administrator
 *
 */
public class TeaCheckQueryCondition {
	//学年
    private String yeartime;
    //学期
    private Integer termtime;
    //考评内容
    private String  checkContent;
    //教师工号
    private String tno;
    //教师姓名
    private String tname;
    //学院
    private String college;
    
    private String courseNo;
    
    
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
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
	public String getCheckContent() {
		return checkContent;
	}
	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
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
    

}
