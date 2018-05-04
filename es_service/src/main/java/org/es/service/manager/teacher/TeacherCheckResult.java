package org.es.service.manager.teacher;
/**
 * 考评结果统计
 * @author Administrator
 *
 */
public class TeacherCheckResult {
	//教师工号
    private String jobno;
    //教师姓名
    private String tname;
    //学院
    private String college;
	//考评内容
    private String checkContent;
	//各选项数量
    private Integer countsYouxiu;
    private Integer countsLianghao;
    private Integer countsZhongdeng;
    private Integer countsJige;
    private Integer countsBujige;
    //学年
    private String yeartime;
    //学期
    private Integer termtime;
    private String courseNo;
    private String courseName;
    
    
    
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public Integer getCountsYouxiu() {
		return countsYouxiu;
	}
	public void setCountsYouxiu(Integer countsYouxiu) {
		this.countsYouxiu = countsYouxiu;
	}
	public Integer getCountsLianghao() {
		return countsLianghao;
	}
	public void setCountsLianghao(Integer countsLianghao) {
		this.countsLianghao = countsLianghao;
	}
	public Integer getCountsZhongdeng() {
		return countsZhongdeng;
	}
	public void setCountsZhongdeng(Integer countsZhongdeng) {
		this.countsZhongdeng = countsZhongdeng;
	}
	public Integer getCountsJige() {
		return countsJige;
	}
	public void setCountsJige(Integer countsJige) {
		this.countsJige = countsJige;
	}
	public Integer getCountsBujige() {
		return countsBujige;
	}
	public void setCountsBujige(Integer countsBujige) {
		this.countsBujige = countsBujige;
	}
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
	public String getCheckContent() {
		return checkContent;
	}
	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
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
