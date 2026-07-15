package com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BalanceDTO {
	
		@NotNull(message = "Account number cannot be null")
	private String accountNumber;
		@NotBlank(message="phone number cannot be blank")
		@Pattern(regexp="^\\d{10}$", message="Phone number must be 10 digits")
	private String phoneNumber;
		@NotBlank(message="Aadhar number cannot be blank")
		@Pattern(regexp="^\\d{12}$", message="Aadhar number must be 12 digits")
	private String aadharNumber;

}
