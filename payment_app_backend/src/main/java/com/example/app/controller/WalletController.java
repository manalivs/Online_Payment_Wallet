package com.example.app.controller;

import java.math.BigInteger;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.beans.Customer;
import com.example.app.beans.Login_Details;
import com.example.app.beans.TransactionDetails;
import com.example.app.exception.ResponseMessage;
import com.example.app.service.WalletService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/api")
public class WalletController {
	
	@Autowired
	WalletService walletService;

	@PostMapping("/customers")
	public ResponseMessage createAccount(@RequestBody Customer customer) {
		return walletService.createAccount(customer);
	}
	
	@PostMapping("/getLogin")
	public ResponseMessage getCustomerById(@RequestBody Login_Details log){
		return walletService.getCustomerById(log);
	}
	
	@GetMapping("/cust/{uid}") 
	 public Customer getCustomerByUpiId(@PathVariable(value = "uid") String upiId){ 
		 return walletService.getCustomerByUpiId(upiId);
	}
	
	@PostMapping("/transactions")
	 public ResponseMessage addMoney(@RequestBody TransactionDetails transactionModel) {
		 return walletService.addMoney(transactionModel);
	}
	@PostMapping("/withdraw")
	 public ResponseMessage withdrawAmount(@RequestBody TransactionDetails transactionModel) {
		 return walletService.withdrawAmount(transactionModel);
	}
	
	@GetMapping("/customers/{id}")
	 public ResponseMessage validate(@PathVariable(value = "id") BigInteger mobileNo){
		return walletService.validate(mobileNo);
	}
	
	@PostMapping("/transfer")
	 public ResponseMessage fundTransfer(@RequestBody TransactionDetails transactionModel){
		return walletService.fundTransfer(transactionModel);
	}
	
	@PostMapping("/change") 
	 public ResponseMessage changePassword(@RequestBody Login_Details log){
		return walletService.changePassword(log);
	}
	
	@GetMapping("/transfer/{uid}") 
	 public List<TransactionDetails> getTransactions(@PathVariable(value = "uid") String upiId){  
		 return walletService.getTransactions(upiId);
	 }
	
	@GetMapping("/check/{uid}/{pass}") 
	 public ResponseMessage checkPassword
	 (@PathVariable(value = "uid") String upiId, @PathVariable(value = "pass") String password){  
		 return walletService.checkPassword(upiId, password);
	 }
	
	@GetMapping("/delete/{uid}")
	public ResponseMessage deleteAccount(@PathVariable(value = "uid") String upiId) {
		return walletService.deleteAccount(upiId);
	}
}	
	