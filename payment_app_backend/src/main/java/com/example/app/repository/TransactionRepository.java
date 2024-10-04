package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.beans.TransactionDetails;

public interface TransactionRepository extends JpaRepository<TransactionDetails	, Integer>{
	public List<TransactionDetails> findByPayeeOrRecipient(String payee, String recipient);

}
