package com.javaweb.pojo;

/**
 * 管理员实体类
 */
public class Admin  {
    private long adminid;
	private String adminname;
	private String adminpassword;
	
	public Admin() {}

	public long getAdminid() {
		return adminid;
	}

	public void setAdminid(long adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}


}