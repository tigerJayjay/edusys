package org.es.model;

public class BookReserve {
    private Integer no;

    private String sno;

    private Integer bookNo;

    private Integer termtime;

    private String yeartime;

    private Integer paystatus;

    private Double payable;

    private Double payin;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public Integer getBookNo() {
        return bookNo;
    }

    public void setBookNo(Integer bookNo) {
        this.bookNo = bookNo;
    }

    public Integer getTermtime() {
        return termtime;
    }

    public void setTermtime(Integer termtime) {
        this.termtime = termtime;
    }

    public String getYeartime() {
        return yeartime;
    }

    public void setYeartime(String yeartime) {
        this.yeartime = yeartime == null ? null : yeartime.trim();
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Double getPayable() {
        return payable;
    }

    public void setPayable(Double payable) {
        this.payable = payable;
    }

    public Double getPayin() {
        return payin;
    }

    public void setPayin(Double payin) {
        this.payin = payin;
    }
}