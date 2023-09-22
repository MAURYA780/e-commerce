package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.ecommerce.dao.MerchantDao;
import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.helper.MainHelper;

import jakarta.validation.Valid;
@Service
public class MerchantService {
	@Autowired
	MerchantDao merchantDao;
	@Autowired
	MainHelper mainHelper;

	public String signup(MerchantDto merchantDto,ModelMap modelMap) {
	MerchantDto merchant1 = merchantDao.fetchByEmail(merchantDto.getEmail());
	MerchantDto merchant2 = merchantDao.fetchByMobile(merchantDto.getMobile());{
		if(merchant1==null && merchant2==null)
		{
			int otp=new Random().nextInt(100000,999999);
			merchantDto.setOtp(otp);
			merchantDao.save(merchantDto);
			mainHelper.sendOtp(merchantDto);
			modelMap.put("id", merchantDto.getId());
			return "VerifyOtp1";
		}
		else {
			if (merchant1 != null) {
				if (merchant1.isStatus()) {
					modelMap.put("neg", "Email Already Exists");
					return "MerchantSignup";
				} else {
					if (merchant2 != null) {
						mainHelper.sendOtp(merchant1);
						modelMap.put("id", merchant1.getId());
						return "VerifyOtp1";
					} else {
						modelMap.put("neg", "Same Email with Different Number Exists");
						return "MerchantSignup";
					}
				}
			}
		else {
				modelMap.put("neg", "Phone Number Already Exists");
				return "MerchantSignup";
			}
		}
		}
	}	
	public String verifyOtp(int id,int otp,ModelMap modelMap) {
		MerchantDto merchantDto=merchantDao.fetchById(id);
		if(merchantDto==null) {
			modelMap.put("neg","Something went worng");
			return "Home";
		}
		else {
			if(merchantDto.getOtp()==otp) {
				merchantDto.setStatus(true);
				merchantDao.save(merchantDto);
				modelMap.put("pos", "Account Verified Successfully");
				return "MerchantDto";
			}
			 else {
					modelMap.put("neg", "OTP MissMatch");
					modelMap.put("id", id);
					return "VerifyOtp1";
				}
		}
	}
	
	public String login(LoginHelper helper, ModelMap map) {
		MerchantDto merchant=merchantDao.fetchByEmail(helper.getEmail());
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
