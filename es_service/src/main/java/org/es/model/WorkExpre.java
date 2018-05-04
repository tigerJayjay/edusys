package org.es.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class WorkExpre implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer no;

    private Integer workerNo;

    private String compony;
    @JSONField(format="yyyy-MM-dd")
    private Date begintime;
    @JSONField(format="yyyy-MM-dd")
    private Date endtime;

    private String positions;

    private String des;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getWorkerNo() {
        return workerNo;
    }

    public void setWorkerNo(Integer workerNo) {
        this.workerNo = workerNo;
    }

    public String getCompony() {
        return compony;
    }

    public void setCompony(String compony) {
        this.compony = compony == null ? null : compony.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions == null ? null : positions.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
}