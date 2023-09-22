package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.dto.CustomerDto;

public interface CustomerRepository extends JpaRepository<CustomerDto, Integer> {

	CustomerDto findByEmail(String email);

	CustomerDto findByMobile(long mobile);

}
