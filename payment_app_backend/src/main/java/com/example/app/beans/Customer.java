package com.example.app.beans;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.app.exception.InsufficientBalanceException;

@Entity
@Table(name="Customer")
public class Customer {
	
	
	@Id
	@Column(name="mobileNo")
	private BigInteger mobileNo;

	@Column(name="fullName")
	private String fullName;
	
	
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Column(name="password")
	private String password;
	
	@Column(name="upiId")
	private String upiId;
	
	@Column(name="balance")
	private long balance;

	public BigInteger getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) throws InsufficientBalanceException{
		if(balance < 0) {
			throw new InsufficientBalanceException("Insufficient Balance!!!");
		}
		else
		{
		this.balance = balance;
		}
	}

	public Customer(BigInteger mobileNo, String fullName, String emailAddress, String password, String upiId,
			long balance) {
		super();
		this.mobileNo = mobileNo;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.upiId = upiId;
		this.balance = balance;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [mobileNo=" + mobileNo + ", fullName=" + fullName + ", emailAddress=" + emailAddress
				+ ", password=" + password + ", upiId=" + upiId + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (balance ^ (balance >>> 32));
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((upiId == null) ? 0 : upiId.hashCode());
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
		Customer other = (Customer) obj;
		if (balance != other.balance)
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
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
		if (upiId == null) {
			if (other.upiId != null)
				return false;
		} else if (!upiId.equals(other.upiId))
			return false;
		return true;
	}
	
	

	
	


		
	
}
