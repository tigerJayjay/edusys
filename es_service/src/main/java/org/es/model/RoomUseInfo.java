package org.es.model;

public class RoomUseInfo {
    private Integer no;

    private Integer roomNo;

    private Integer startWeek;

    private Integer endWeek;

    private Integer weekth;

    private String jie;

    private String memo;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Integer getWeekth() {
        return weekth;
    }

    public void setWeekth(Integer weekth) {
        this.weekth = weekth;
    }

    public String getJie() {
        return jie;
    }

    public void setJie(String jie) {
        this.jie = jie == null ? null : jie.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}