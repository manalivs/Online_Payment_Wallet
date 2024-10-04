package com.example.app.beans;

import java.math.BigInteger;

public class Login_Details {
	
	private BigInteger mobileNo;
	private String password;
	public Login_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login_Details(BigInteger mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}
	public BigInteger getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login_Details [mobileNo=" + mobileNo + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login_Details other = (Login_Details) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
	

}
