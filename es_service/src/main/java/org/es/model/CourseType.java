package org.es.model;

public class CourseType {
    private Integer couseno;

    private String typeName;

    public Integer getCouseno() {
        return couseno;
    }

    public void setCouseno(Integer couseno) {
        this.couseno = couseno;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}