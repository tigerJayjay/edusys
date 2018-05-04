package org.es.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer no;

    private String roleName;

    private List<Authority> AuthList;
    public List<Authority> getAuthList() {
		return AuthList;
	}

	public void setAuthList(List<Authority> authList) {
		AuthList = authList;
	}

	public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}