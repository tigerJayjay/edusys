package org.es.model;

import java.io.Serializable;

public class Authority implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer authNo;

    private String authName;

    private String url;

    public Integer getAuthNo() {
        return authNo;
    }

    public void setAuthNo(Integer authNo) {
        this.authNo = authNo;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}