package com.bean;

public class RegisterBean {
	private String uname;
	private String pwd;
	private String email;
	private String address;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RegisterBean(String uname, String pwd, String email, String address) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.address = address;
	}
}
