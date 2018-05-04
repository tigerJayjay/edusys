package org.es.model;

public class Classroom {
    private Integer no;

    private String classno;

    private String buildingno;

    private String towerno;

    private String placeno;

    private Integer capacity;
    
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno == null ? null : classno.trim();
    }

    public String getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(String buildingno) {
        this.buildingno = buildingno == null ? null : buildingno.trim();
    }

    public String getTowerno() {
        return towerno;
    }

    public void setTowerno(String towerno) {
        this.towerno = towerno == null ? null : towerno.trim();
    }

    public String getPlaceno() {
        return placeno;
    }

    public void setPlaceno(String placeno) {
        this.placeno = placeno == null ? null : placeno.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}