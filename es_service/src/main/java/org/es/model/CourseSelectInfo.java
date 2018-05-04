package org.es.model;

public class CourseSelectInfo {
    private String selectno;

    private String sno;

    private String scheNo;

    private Integer isbook;

    public String getSelectno() {
        return selectno;
    }

    public void setSelectno(String selectno) {
        this.selectno = selectno == null ? null : selectno.trim();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getScheNo() {
        return scheNo;
    }

    public void setScheNo(String scheNo) {
        this.scheNo = scheNo == null ? null : scheNo.trim();
    }

    public Integer getIsbook() {
        return isbook;
    }

    public void setIsbook(Integer isbook) {
        this.isbook = isbook;
    }
}