package org.es.model;

public class Selection {
    private Integer no;

    private String selection;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection == null ? null : selection.trim();
    }
}