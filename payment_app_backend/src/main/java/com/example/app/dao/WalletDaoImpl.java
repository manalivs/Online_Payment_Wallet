package com.example.app.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.beans.Customer;
import com.example.app.beans.Login_Details;
import com.example.app.beans.TransactionDetails;
import com.example.app.exception.DataNotFoundException;
import com.example.app.exception.ResponseMessage;
import com.example.app.exception.IncorrectPasswordException;
import com.example.app.exception.InsufficientBalanceException;
import com.example.app.repository.CustomerRepository;
import com.example.app.repository.TransactionRepository;

@Repository
public class WalletDaoImpl implements WalletDao{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public ResponseMessage createAccount(Customer customer) {
		ResponseMessage response = new ResponseMessage();
		Customer cust = customerRepository.findByUpiId(customer.getUpiId());
		if(cust != null) {
			response.setErrorMessage("Customer Already Exists!!!");
		}
		else {
			customerRepository.save(customer);
			response.setErrorMessage("Account Created Successfully...");
		}
		return response;
}

	@Override
	public ResponseMessage getCustomerById(Login_Details log)  {
		ResponseMessage response = new ResponseMessage();
		try {
			Customer customer = 
					customerRepository.findById(log.getMobileNo()).orElseThrow(()-> new DataNotFoundException("Customer Not Found!!!"));
			
			if(customer.getPassword().equals(log.getPassword())) {
				response.setErrorMessage("Login Successful...");
			}
			else {
				response.setErrorMessage("Incorrect Password!!!");
			}
		}
		catch(DataNotFoundException e)
		{
			response.setErrorMessage(e.getMessage());
		}
		finally {
			return response;
		}
	}

	@Override
	public Customer getCustomerByUpiId(String upiId) {
		Customer customer = customerRepository.findByUpiId(upiId); 
		return customer;
	}

	@Override
	public ResponseMessage addMoney(TransactionDetails transactionModel) {
		ResponseMessage response = new ResponseMessage();
		Customer customer= customerRepository.findByUpiId(transactionModel.getPayee());
		try {
			customer.setBalance(customer.getBalance()+transactionModel.getTransfer_amount());
			response.setErrorMessage("Transaction Successful");
			transactionRepository.save(transactionModel);
		} 
		catch (Exception e) {
		}
		finally {
			return response;
		}
	}

	@Override
	public ResponseMessage withdrawAmount(TransactionDetails transactionModel) {
		ResponseMessage response = new ResponseMessage();
		Customer customer= customerRepository.findByUpiId(transactionModel.getPayee());
		 try {
			customer.setBalance(customer.getBalance()-transactionModel.getTransfer_amount());
			response.setErrorMessage("Transaction Successful");
			transactionRepository.save(transactionModel);
		} 
		 catch (InsufficientBalanceException e) {
			response.setErrorMessage(e.getMessage());
		}
		finally {
			return response;
		}
	}

	@Override
	public ResponseMessage validate(BigInteger mobileNo) {
		ResponseMessage response = new ResponseMessage();
		try {
			Customer customer = 
					customerRepository.findById(mobileNo).orElseThrow(()->new DataNotFoundException("Customer Not Found!!!"));
			if (customer != null) {
				response.setErrorMessage("Customer Validated.");
			}
		}
		catch(DataNotFoundException e)
		{
			response.setErrorMessage(e.getMessage());
			
		}
		finally {
			return response;
		}
	}

	@Override
	public ResponseMessage fundTransfer(TransactionDetails transactionModel) {
		ResponseMessage response = new ResponseMessage();
		 try {
		 
			 Customer customer= customerRepository.findByUpiId(transactionModel.getPayee());
			 customer.setBalance(customer.getBalance()-transactionModel.getTransfer_amount());
			 Customer customer1= customerRepository.findByUpiId(transactionModel.getRecipient());
			 customer1.setBalance(customer1.getBalance()+transactionModel.getTransfer_amount());
			 transactionRepository.save(transactionModel);
			 response.setErrorMessage("Payment Successsful.");
		 }
		catch(InsufficientBalanceException e)
		{
			response.setErrorMessage(e.getMessage());
				
		}
		finally {
			return response;
		}
	}

	@Override
	public ResponseMessage changePassword(Login_Details log) {
//		ResponseMessage response = new ResponseMessage();
//		 Optional<Customer> customer = customerRepository.findById(log.getMobileNo());
//		 Customer cust = customer.get();
//		 
//		 Customer newcust = new Customer(cust.getMobileNo(),cust.getFullName(),cust.getEmailAddress(),log.getPassword(),
//				 cust.getUpiId(),cust.getBalance());
//		 customerRepository.delete(cust);
//		 customerRepository.save(newcust);
//		 
//		 response.setErrorMessage("Password Changed.");
//		 return response;
		ResponseMessage response = new ResponseMessage();
		Customer customer = customerRepository.findById(log.getMobileNo()).get();
		customer.setPassword(log.getPassword());
		customerRepository.save(customer);
		response.setErrorMessage("Password Changed.");
		return response;
		
	}

	@Override
	public List<TransactionDetails> getTransactions(String upiId) {
		return transactionRepository.findByPayeeOrRecipient(upiId, upiId);
	}

	@Override
	public ResponseMessage checkPassword(String upiId, String password) {
		ResponseMessage response = new ResponseMessage();
		try {
			Customer customer = customerRepository.findByUpiId(upiId);
			if(customer.getPassword().equals(password)) {
				response.setErrorMessage("Correct Password.");
			}
			else {
				throw new IncorrectPasswordException("Incorrect Password. Please try again!!!");
			}
			
		}
		catch( IncorrectPasswordException e) {
			response.setErrorMessage(e.getMessage());
		}
		finally {
			return response;
			
		}
		
	}

	@Override
	public ResponseMessage deleteAccount(String upiId) {
		ResponseMessage response = new ResponseMessage();
		Customer customer = customerRepository.findByUpiId(upiId);
		customerRepository.delete(customer);
		response.setErrorMessage("Account Deleted!!!");
		return response;
	}

}
