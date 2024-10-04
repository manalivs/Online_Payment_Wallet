package com.example.app.dao;



import java.math.BigInteger;
import java.util.List;

import com.example.app.beans.Customer;
import com.example.app.beans.Login_Details;
import com.example.app.beans.TransactionDetails;
import com.example.app.exception.ResponseMessage;

public interface WalletDao {
	
	public ResponseMessage createAccount(Customer customer);
	public ResponseMessage getCustomerById(Login_Details log);
	public Customer getCustomerByUpiId(String upiId);
	public ResponseMessage addMoney(TransactionDetails transactionModel);
	public ResponseMessage withdrawAmount(TransactionDetails transactionModel);
	public ResponseMessage validate(BigInteger mobileNo);
	public ResponseMessage fundTransfer(TransactionDetails transactionModel);
	public ResponseMessage changePassword(Login_Details log);
	public List<TransactionDetails> getTransactions(String upiId);
	public ResponseMessage checkPassword(String upiId, String password);
	public ResponseMessage deleteAccount(String upiId);

}
