package com.java.entity;

import java.sql.Date;

public class Inventory {
	private int iid;
	private int cid;
	private int icod;
	private int inum;
	private Date idate;
	private String iis;
	private int uid;
	private String mark;
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int iid, int cid, int icod, int inum, Date idate, String iis, int uid, String mark) {
		super();
		this.iid = iid;
		this.cid = cid;
		this.icod = icod;
		this.inum = inum;
		this.idate = idate;
		this.iis = iis;
		this.uid = uid;
		this.mark = mark;
	}
	
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getIcod() {
		return icod;
	}
	public void setIcod(int icod) {
		this.icod = icod;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public String getIis() {
		return iis;
	}
	public void setIis(String iis) {
		this.iis = iis;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Inventory [iid=" + iid + ", cid=" + cid + ", icod=" + icod + ", inum=" + inum + ", idate=" + idate
				+ ", iis=" + iis + ", uid=" + uid + ", mark=" + mark + "]";
	}

}
