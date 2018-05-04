package org.es.model;

import java.util.Date;

public class OperatorRecord {
    private Integer no;

    private String oprno;

    private Date oprtime;

    private String content;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getOprno() {
        return oprno;
    }

    public void setOprno(String oprno) {
        this.oprno = oprno == null ? null : oprno.trim();
    }

    public Date getOprtime() {
        return oprtime;
    }

    public void setOprtime(Date oprtime) {
        this.oprtime = oprtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}