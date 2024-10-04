package com.example.app.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {
	public Customer findByUpiId(String upiId);
	

}
