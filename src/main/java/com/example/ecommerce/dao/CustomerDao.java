package com.example.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;

	public CustomerDto fetchByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public CustomerDto fetchByMobile(long mobile) {
		return customerRepository.findByMobile(mobile);
	}

	public CustomerDto save(CustomerDto customer) {
		return customerRepository.save(customer);
	}
	
	public CustomerDto fetchById(int id)
	{
		return customerRepository.findById(id).orElse(null);
	}

}
