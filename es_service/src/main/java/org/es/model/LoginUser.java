package org.es.model;

import java.io.Serializable;
import java.util.List;

public class LoginUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer no;

    private String account;

    private String password;

    private Integer userMark;

    private transient List<Role> roleList;
    
    public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserMark() {
        return userMark;
    }

    public void setUserMark(Integer userMark) {
        this.userMark = userMark;
    }
}