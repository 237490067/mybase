package com.java.entity;

public class Sheng {
	private int s_id;
	private String s_name;
	public Sheng() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sheng(int s_id, String s_name) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
	}
	@Override
	public String toString() {
		return "Sheng [s_id=" + s_id + ", s_name=" + s_name + "]";
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	

}
