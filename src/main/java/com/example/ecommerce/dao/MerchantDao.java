package com.example.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.repository.MerchantRepository;

import jakarta.validation.Valid;
@Repository
public class MerchantDao {
	@Autowired
	MerchantRepository merchantRepository;
	
	public MerchantDto fetchByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}

	public MerchantDto fetchByMobile(long mobile) {
		return merchantRepository.findByMobile(mobile);
	}
	public MerchantDto save(MerchantDto merchantDto) {
		return merchantRepository.save(merchantDto);
		
	}

	public MerchantDto fetchById(int id) {
		return merchantRepository.findById(id).orElse(null);
	}

}
