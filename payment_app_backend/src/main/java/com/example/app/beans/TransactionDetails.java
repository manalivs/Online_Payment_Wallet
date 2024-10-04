package com.example.app.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Transaction_Details")
public class TransactionDetails {
	
	@Id
	@Column(name="Transaction_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_no;
	
	@Column(name="Payee")
	private String payee;
	
	@Column(name="Recipient")
	private String recipient;
	
	@Column(name="Amount")
	private long transfer_amount;
	
	@Column(name="Caption")
	private String caption;
	
	@Temporal(TemporalType.DATE)
	@Column(name=  "Transaction_date")
	private Date transaction_date;
	
	@Temporal(TemporalType.TIME)
	@Column(name=  "Transaction_time")
	private Date transaction_time;

	public TransactionDetails() {
		super();
	}

	public TransactionDetails(int transaction_no, String payee, String recipient, long transfer_amount, String caption,
			Date transaction_date, Date transaction_time) {
		super();
		this.transaction_no = transaction_no;
		this.payee = payee;
		this.recipient = recipient;
		this.transfer_amount = transfer_amount;
		this.caption = caption;
		this.transaction_date = transaction_date;
		this.transaction_time = transaction_time;
	}

	public int getTransaction_no() {
		return transaction_no;
	}

	public void setTransaction_no(int transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public long getTransfer_amount() {
		return transfer_amount;
	}

	public void setTransfer_amount(long transfer_amount) {
		this.transfer_amount = transfer_amount;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public Date getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Date transaction_time) {
		this.transaction_time = transaction_time;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transaction_no=" + transaction_no + ", payee=" + payee + ", recipient=" + recipient
				+ ", transfer_amount=" + transfer_amount + ", caption=" + caption + ", transaction_date="
				+ transaction_date + ", transaction_time=" + transaction_time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((payee == null) ? 0 : payee.hashCode());
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((transaction_date == null) ? 0 : transaction_date.hashCode());
		result = prime * result + transaction_no;
		result = prime * result + ((transaction_time == null) ? 0 : transaction_time.hashCode());
		result = prime * result + (int) (transfer_amount ^ (transfer_amount >>> 32));
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
		TransactionDetails other = (TransactionDetails) obj;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (payee == null) {
			if (other.payee != null)
				return false;
		} else if (!payee.equals(other.payee))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (transaction_date == null) {
			if (other.transaction_date != null)
				return false;
		} else if (!transaction_date.equals(other.transaction_date))
			return false;
		if (transaction_no != other.transaction_no)
			return false;
		if (transaction_time == null) {
			if (other.transaction_time != null)
				return false;
		} else if (!transaction_time.equals(other.transaction_time))
			return false;
		if (transfer_amount != other.transfer_amount)
			return false;
		return true;
	}
	
	

	
}
