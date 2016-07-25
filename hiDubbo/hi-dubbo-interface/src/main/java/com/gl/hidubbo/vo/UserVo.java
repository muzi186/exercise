package com.gl.hidubbo.vo;

import java.io.Serializable;

public class UserVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482576029163101621L;
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
