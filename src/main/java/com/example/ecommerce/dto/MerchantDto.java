package com.example.ecommerce.dto;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Component
public class MerchantDto {
	
	@Id
	@GeneratedValue(generator = "merchant_id")
	@SequenceGenerator(name = "merchant_id", initialValue = 111001, allocationSize = 1,sequenceName ="merchant_id" )
	private int id;
	@Size(min = 5,message="Atleast enter 5 character")
	private String name;
	@Email(message="Email formate is not correct")
	@NotEmpty(message = "Must not be empty")
	private String email;
	@NotNull
	@DecimalMin(value="6000000000", message="Enter Proper Number")
	@DecimalMax(value="10000000000", message="Enter Proper Number")
	private long mobile;
	@Size(min=8,message="password should be 8 chracters")
	private String password;
	@NotEmpty(message="select atleast one the gender")
	private String gender;
	@Past(message = "Date must not be todays or futures date")
	@NotNull(message = "Must not be empty")
	private LocalDate dob;
	private boolean status;	
	private int otp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	List<ProductDto> products;

}
