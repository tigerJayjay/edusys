package org.es.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class WorkerAward implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String workName;
    private Integer no;
    @JSONField(format="yyyy-MM-dd")
    private Date awardtime;

    private String des;

    private Integer workerNo;

    public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getAwardtime() {
        return awardtime;
    }

    public void setAwardtime(Date awardtime) {
        this.awardtime = awardtime;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Integer getWorkerNo() {
        return workerNo;
    }

    public void setWorkerNo(Integer workerNo) {
        this.workerNo = workerNo;
    }
}