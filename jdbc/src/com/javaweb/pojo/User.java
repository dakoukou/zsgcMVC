package com.javaweb.pojo;

/**
 * 用户实体类
 * 
 */
public class User {
	private Long userid;
	private String username;
	private String password;

	public User() {

	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}