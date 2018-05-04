package org.es.model;

public class RecordInfo {
    private String recordno;

    private String stuUniNo;

    private String selectionkey;

    private String admissionno;

    private Integer postcode;

    private String idnumber;

    private String eduGradation;

    private String nativespace;

    private String nation;

    public String getRecordno() {
        return recordno;
    }

    public void setRecordno(String recordno) {
        this.recordno = recordno == null ? null : recordno.trim();
    }

    public String getStuUniNo() {
        return stuUniNo;
    }

    public void setStuUniNo(String stuUniNo) {
        this.stuUniNo = stuUniNo == null ? null : stuUniNo.trim();
    }

    public String getSelectionkey() {
        return selectionkey;
    }

    public void setSelectionkey(String selectionkey) {
        this.selectionkey = selectionkey == null ? null : selectionkey.trim();
    }

    public String getAdmissionno() {
        return admissionno;
    }

    public void setAdmissionno(String admissionno) {
        this.admissionno = admissionno == null ? null : admissionno.trim();
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getEduGradation() {
        return eduGradation;
    }

    public void setEduGradation(String eduGradation) {
        this.eduGradation = eduGradation == null ? null : eduGradation.trim();
    }

    public String getNativespace() {
        return nativespace;
    }

    public void setNativespace(String nativespace) {
        this.nativespace = nativespace == null ? null : nativespace.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }
}