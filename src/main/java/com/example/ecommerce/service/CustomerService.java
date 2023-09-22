package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.ecommerce.dao.CustomerDao;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.helper.MainHelper;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	MainHelper mailHelper;

	public String signup(CustomerDto customerDto, ModelMap modelMap) {
		CustomerDto customer1 = customerDao.fetchByEmail(customerDto.getEmail());
		CustomerDto customer2 = customerDao.fetchByMobile(customerDto.getMobile());
		if (customer1 == null && customer2 == null) {
			int otp = new Random().nextInt(100000, 999999);
			customerDto.setOtp(otp);
			customerDao.save(customerDto);
			mailHelper.sendOtp(customerDto);
			modelMap.put("id", customerDto.getId());
			return "VerifyOtp2";
		} else {
			if (customer1 != null) {
				if (customer1.isStatus()) {
					modelMap.put("neg", "Email Already Exists");
					return "CustomerSignup";
				} else {
					if (customer2 != null) {
						mailHelper.sendOtp(customer1);
						modelMap.put("id", customer1.getId());
						return "VerifyOtp2";
					} else {
						modelMap.put("neg", "Same Email with Different Number Exists");
						return "CustomerSignup";
					}
				}
			} else {
				modelMap.put("neg", "Phone Number Already Exists");
				return "CustomerSignup";
			}
		}
	}

	public String verfiyOtp(int id, int otp, ModelMap modelMap) {
		CustomerDto customerDto = customerDao.fetchById(id);
		if (customerDto == null) {
			modelMap.put("neg", "Something went Wrong");
			return "Main";
		} else {
			if (customerDto.getOtp() == otp) {
				customerDto.setStatus(true);
				customerDao.save(customerDto);
				modelMap.put("pos", "Account Verified Successfully");
				return "Customer";
			} else {
				modelMap.put("neg", "OTP MissMatch");
				modelMap.put("id", id);
				return "VerifyOtp2";
			}
		}
	}

	public String login(LoginHelper helper, ModelMap map, HttpSession session) {
		CustomerDto merchant=customerDao.fetchByEmail(helper.getEmail());
		if(merchant==null)
		{
			map.put("neg", "InCorrect Email");
			return "Merchant";
		}
		else {
			if(merchant.getPassword().equals(helper.getPassword()))
			{
				if(merchant.isStatus())
				{
				map.put("pos", "Login Success");
				return "MerchantHome";
				}
				else {
					map.put("neg", "Verify Your OTP First");
					return "Merchant";
				}
			}
			else {
				map.put("neg", "InCorrect Password");
				return "Merchant";
			}
		}
	}


}
