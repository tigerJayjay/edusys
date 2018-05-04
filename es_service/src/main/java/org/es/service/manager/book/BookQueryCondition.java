package org.es.service.manager.book;
/**
 * 教材一类查询条件
 * @author Administrator
 *
 */
public class BookQueryCondition {
	private Integer bookNo;
    private String bookname;
    private String press;
    private String sno;
    private String sname;
    private Integer paystatus;
    private String yeartime;
    private Integer termtime;
    private String college;
    private String classno;
    
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
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
	public Integer getBookNo() {
		return bookNo;
	}
	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
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
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
    
    
}
