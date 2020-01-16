package com.java.entity;

public class City {
	private int s_id;
	private int c_id;
	private String c_name;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(int s_id, int c_id, String c_name) {
		super();
		this.s_id = s_id;
		this.c_id = c_id;
		this.c_name = c_name;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	@Override
	public String toString() {
		return "City [s_id=" + s_id + ", c_id=" + c_id + ", c_name=" + c_name + "]";
	}
	

}
