package com.java.entity;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String upassword) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
	}
	public User(String uname, String upassword) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + "]";
	}

}
