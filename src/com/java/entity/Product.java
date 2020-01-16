package com.java.entity;

public class Product {
	private int pid;
	private int pnum;
	private String name;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, int pnum2, String name) {
		super();
		this.pid = pid;
		this.pnum = pnum2;
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pnum=" + pnum + ", name=" + name + "]";
	}
	

}
