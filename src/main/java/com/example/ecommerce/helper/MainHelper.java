package com.example.ecommerce.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.dto.MerchantDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class MainHelper {
	@Autowired
	JavaMailSender mailSender;
	
	public void sendOtp(MerchantDto merchantDto) {
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage);
		try {
			messageHelper.setTo(merchantDto.getEmail());
			messageHelper.setFrom("E-Commerce");
			messageHelper.setSubject("OTP Verification");
			String body="<h1 style='color:blue'>hello "+merchantDto.getName()+",<br>Your Otp is : "+merchantDto.getOtp()+"</h1>";
			messageHelper.setText(body,true);
			mailSender.send(mimeMessage);
			}
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendOtp(CustomerDto customerDto) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

		try {
			messageHelper.setTo(customerDto.getEmail());
			messageHelper.setFrom("E-Commerce");
			messageHelper.setSubject("OTP Verification");
			String body = "<h1 style='color:blue'>Hello " + customerDto.getName() + ",<br>Your Otp is : "
					+ customerDto.getOtp() + "</h1>";
			messageHelper.setText(body, true);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	
		
	}

}
