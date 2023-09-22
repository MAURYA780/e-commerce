package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.dto.MerchantDto;

public interface MerchantRepository extends JpaRepository<MerchantDto, Integer>{

	MerchantDto findByEmail(String email);

	MerchantDto findByMobile(long mobile);

	
}
