package org.es.model;

public class ExamArrangement {
    private Integer no;

    private String sno;

    private Integer seatNumber;

    private Integer examno;

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

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getExamno() {
        return examno;
    }

    public void setExamno(Integer examno) {
        this.examno = examno;
    }
}