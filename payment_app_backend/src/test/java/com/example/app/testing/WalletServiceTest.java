package com.example.app.testing;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.beans.Customer;
import com.example.app.beans.Login_Details;
import com.example.app.beans.TransactionDetails;
import com.example.app.exception.ResponseMessage;
import com.example.app.service.WalletServiceImpl;

@Transactional
@SpringBootTest
public class WalletServiceTest {
	
	private static Logger logger=LogManager.getRootLogger();
	
	@Autowired
	WalletServiceImpl walletService;
	
	@BeforeAll
	static void setUpBeforeClass() {
		logger = LogManager.getRootLogger();
		System.out.println("Fetching resources for testing ...");
	}
	
	@Test
	@DisplayName("Customer Registration Fails- Customer Already Exists")
	@Rollback(true)
	public void createAccountFirstTest() throws Exception {
		logger.info("Test Case -Customer Registration Fails- Customer Already Exists");
		Customer customer = new Customer(new BigInteger("9422346143"),"Manali","mvs@gmail.com","9422","9422346143@WalletApp",0);
		ResponseMessage response = walletService.createAccount(customer);
		String expectedMessage = "Customer Already Exists!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	
	/*
	 * @Test
	 * 
	 * @DisplayName("Customer Registration Successful")
	 * 
	 * @Rollback(true) public void createAccountSecondTest() throws Exception {
	 * logger.info("Test Case - Customer Registration Successful"); Customer
	 * customer = new Customer(new
	 * BigInteger("1212121213"),"Manali","m11@gmail.com","1212",
	 * "1212121213@WalletApp",0); ResponseMessage response =
	 * walletService.createAccount(customer); String expectedMessage =
	 * "Account Created Successfully..."; String message =
	 * response.getErrorMessage(); assertEquals(expectedMessage, message);
	 * 
	 * }
	 */

	
	@Test
	@DisplayName("Customer Login Successful")
	@Rollback(true)
	public void loginFirstTest() throws Exception {
		logger.info("Test Case - Customer Login Successful");
		Login_Details log = new Login_Details(new BigInteger("9422346143"),"9421");
		ResponseMessage response = walletService.getCustomerById(log);
		String expectedMessage = "Login Successful...";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Login Fails- Customer Not Found ")
	@Rollback(true)
	public void loginSecondTest() throws Exception {
		logger.info("Test Case - Customer Login Fails- Customer Not Found");
		Login_Details log = new Login_Details(new BigInteger("2222222222"),"9422");
		ResponseMessage response = walletService.getCustomerById(log);
		String expectedMessage = "Customer Not Found!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Login Fails- Incorrect Password ")
	@Rollback(true)
	public void loginThirdTest() throws Exception {
		logger.info("Test Case - Customer Login Fails- Incorrect Password");
		Login_Details log = new Login_Details(new BigInteger("9422346143"),"9444");
		ResponseMessage response = walletService.getCustomerById(log);
		String expectedMessage = "Incorrect Password!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Login - Correct Password.")
	@Rollback(true)
	public void checkPasswordFirstTest() throws Exception {
		logger.info("Test Case - Customer Login - Correct Password.");
		String upiId = "9422346143@WalletApp";
		String password = "9421";
		ResponseMessage response = walletService.checkPassword(upiId, password);
		String expectedMessage = "Correct Password.";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Login - Incorrect Password")
	@Rollback(true)
	public void checkPasswordSecondTest() throws Exception {
		logger.info("Test Case - Customer Login - Incorrect Password");
		String upiId = "9422346143@WalletApp";
		String password = "9400";
		ResponseMessage response = walletService.checkPassword(upiId, password);
		String expectedMessage = "Incorrect Password. Please try again!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Transaction Successful- Add Money")
	@Rollback(true)
	public void addMoneyTest() throws Exception{
		logger.info("Test Case - Customer Transaction Successful- Add Money");
		TransactionDetails transactionModel = 
				new TransactionDetails(1,"9422346143@WalletApp", "9422346143@WalletApp",(long) 10,"Add",new Date(), new Date());
		ResponseMessage response = walletService.addMoney(transactionModel);
		String expectedMessage = "Transaction Successful";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Transaction Successful- withdraw Amount")
	@Rollback(true)
	public void withdrawAmountFirstTest() throws Exception{
		logger.info("Test Case - Customer Transaction Successful- withdraw Amount");
		TransactionDetails transactionModel = 
				new TransactionDetails(1,"9422346143@WalletApp", "9422346143@WalletApp",(long) 10,"Withdraw",new Date(), new Date());
		ResponseMessage response = walletService.withdrawAmount(transactionModel);
		String expectedMessage = "Transaction Successful";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Transaction Fails- withdraw Amount- Insufficient Balance")
	@Rollback(true)
	public void withdrawAmountSecondTest() throws Exception{
		logger.info("Test Case - Customer Transaction Fails- withdraw Amount- Insufficient Balance");
		TransactionDetails transactionModel = 
				new TransactionDetails(1,"9422346143@WalletApp", "9422346143@WalletApp",(long) 100000,"Withdraw",new Date(), new Date());
		ResponseMessage response = walletService.withdrawAmount(transactionModel);
		String expectedMessage = "Insufficient Balance!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Fund Transfer- Customer Validated")
	@Rollback(true)
	public void fundTransferFirstTest() throws Exception {
		logger.info("Test Case - Customer Fund Transfer- Customer Validated");
		ResponseMessage response = walletService.validate(new BigInteger("9422346143"));
		String expectedMessage = "Customer Validated.";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Fund Transfer Fails- Customer Not Found")
	@Rollback(true)
	public void fundTransferSecondTest() throws Exception {
		logger.info("Test Case - Customer Fund Transfer Fails- Customer Not Found");
		ResponseMessage response = walletService.validate(new BigInteger("3333333333"));
		String expectedMessage = "Customer Not Found!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Fund Transfer- Successsful")
	@Rollback(true)
	public void fundTransferThirdTest() throws Exception {
		logger.info("Test Case - Customer Fund Transfer- Successsful");
		TransactionDetails transactionModel = 
			new TransactionDetails(1,"9422346143@WalletApp", "7588604252@WalletApp",(long) 10,"Send",new Date(), new Date());
		ResponseMessage response = walletService.fundTransfer(transactionModel);
		String expectedMessage = "Payment Successsful.";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
		
	}
	
	@Test
	@DisplayName("Customer Fund Transfer Fails- Insufficient Balance")
	@Rollback(true)
	public void fundTransferForthTest() throws Exception {
		logger.info("Test Case - Customer Fund Transfer Fails- Insufficient Balance");
		TransactionDetails transactionModel = 
				new TransactionDetails(1,"9422346143@WalletApp", "7588604252@WalletApp",(long) 100000,"Send",new Date(), new Date());
		ResponseMessage response = walletService.fundTransfer(transactionModel);
		String expectedMessage = "Insufficient Balance!!!";
		String message = response.getErrorMessage();
		assertEquals(expectedMessage, message);
	}
	
	
	

}
