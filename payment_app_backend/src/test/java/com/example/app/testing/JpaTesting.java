package com.example.app.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app.beans.Customer;
import com.example.app.exception.InsufficientBalanceException;
import com.example.app.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class JpaTesting {
	@Autowired
	CustomerRepository customerRepository;;
	
	@Test
    public void create() throws InsufficientBalanceException{
		Customer cust = new Customer();
		cust.setMobileNo(new BigInteger("9422346143"));
		cust.setFullName("Manali");
		cust.setEmailAddress("mvs@gmail.com");
		cust.setPassword("9422");
		cust.setUpiId("9422346143@WalletApp");
		cust.setBalance((long) 200);
		
		customerRepository.save(cust);
		Optional<Customer> c=customerRepository.findById(new BigInteger("9422346143"));
		Customer customer = c.get();
		assertEquals(cust.getFullName(), customer.getFullName());
		assertEquals(cust.getBalance(), customer.getBalance());
	}
	@Test
	public void update() throws InsufficientBalanceException{
		Customer cust = new Customer();
		cust.setMobileNo(new BigInteger("9422346143"));
		cust.setFullName("Manali");
		cust.setEmailAddress("mvs@gmail.com");
		cust.setPassword("9422");
		cust.setUpiId("9422346143@WalletApp");
		cust.setBalance((long) 200);
		
		customerRepository.save(cust);
		Optional<Customer> c=customerRepository.findById(new BigInteger("9422346143"));
		Customer customer = c.get();
		customer.setBalance(100);
		customer.setFullName("Manali Shelar");
		customerRepository.save(customer);
		assertNotEquals(cust.getFullName(), customer.getFullName());
		assertNotEquals(cust.getBalance(), customer.getBalance());
	}
	@Test
	public void getAll() throws InsufficientBalanceException {
		Customer cust = new Customer();
		cust.setMobileNo(new BigInteger("9422346143"));
		cust.setFullName("Manali");
		cust.setEmailAddress("mvs@gmail.com");
		cust.setPassword("9422");
		cust.setUpiId("9422346143@WalletApp");
		cust.setBalance((long) 200);
		
		customerRepository.save(cust);
		assertNotNull(customerRepository.findAll());
	}

}

