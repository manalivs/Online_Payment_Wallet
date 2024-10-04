package com.example.app.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.beans.Customer;
import com.example.app.beans.Login_Details;
import com.example.app.beans.TransactionDetails;
import com.example.app.dao.WalletDao;
import com.example.app.exception.ResponseMessage;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	WalletDao walletDao;


	@Override
	public ResponseMessage createAccount(Customer customer) {
		return walletDao.createAccount(customer);
	}

	@Override
	public ResponseMessage getCustomerById(Login_Details log) {
		return walletDao.getCustomerById(log);
	}

	@Override
	public Customer getCustomerByUpiId(String upiId) {
		return walletDao.getCustomerByUpiId(upiId);
	}

	@Override
	public ResponseMessage addMoney(TransactionDetails transactionModel) {
		return walletDao.addMoney(transactionModel);
	}

	@Override
	public ResponseMessage withdrawAmount(TransactionDetails transactionModel) {
		return walletDao.withdrawAmount(transactionModel);
	}

	@Override
	public ResponseMessage validate(BigInteger mobileNo) {
		return walletDao.validate(mobileNo);
	}

	@Override
	public ResponseMessage fundTransfer(TransactionDetails transactionModel) {
		return walletDao.fundTransfer(transactionModel);
	}

	@Override
	public ResponseMessage changePassword(Login_Details log) {
		return walletDao.changePassword(log);
	}

	@Override
	public List<TransactionDetails> getTransactions(String upiId) {
		return walletDao.getTransactions(upiId);
	}

	@Override
	public ResponseMessage checkPassword(String upiId, String password) {
		return walletDao.checkPassword(upiId, password);
	}

	@Override
	public ResponseMessage deleteAccount(String upiId) {
		return walletDao.deleteAccount(upiId);
	}

}
