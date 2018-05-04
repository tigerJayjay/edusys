package org.es.service.manager.logger;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 操作记录查询条件类
 * @author Administrator
 *
 */
public class OperatorQueryCondition {
	private String oprno;
	private String oprname;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date beginOprTime;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endOprTime;
	public String getOprno() {
		return oprno;
	}
	public void setOprno(String oprno) {
		this.oprno = oprno;
	}
	public String getOprname() {
		return oprname;
	}
	public void setOprname(String oprname) {
		this.oprname = oprname;
	}
	public Date getBeginOprTime() {
		return beginOprTime;
	}
	public void setBeginOprTime(Date beginOprTime) {
		this.beginOprTime = beginOprTime;
	}
	public Date getEndOprTime() {
		return endOprTime;
	}
	public void setEndOprTime(Date endOprTime) {
		this.endOprTime = endOprTime;
	}
	
	
	
}
