package com.cts.model;

public class Product {
	int oid;
	int pid;
	String pname;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int oid, int pid, String pname) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.pname = pname;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	

}
