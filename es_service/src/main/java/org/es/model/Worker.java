package org.es.model;

public class Worker {
    private Integer no;

    private String workerNo;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getWorkerNo() {
        return workerNo;
    }

    public void setWorkerNo(String workerNo) {
        this.workerNo = workerNo == null ? null : workerNo.trim();
    }
}