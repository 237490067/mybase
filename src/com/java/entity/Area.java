package com.java.entity;

public class Area {
	private int c_id;
	private int a_id;
	private String a_name;
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Area(int c_id, int a_id, String a_name) {
		super();
		this.c_id = c_id;
		this.a_id = a_id;
		this.a_name = a_name;
	}
	@Override
	public String toString() {
		return "Area [c_id=" + c_id + ", a_id=" + a_id + ", a_name=" + a_name + "]";
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	

}
