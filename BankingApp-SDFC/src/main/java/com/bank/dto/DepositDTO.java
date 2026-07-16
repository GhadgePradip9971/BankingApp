package com.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data

public class DepositDTO {
	
	@NotNull(message = "Account number cannot be null")
	private String accountNumber;
	@NotNull(message = "Deposit amount cannot be null")
	@Positive(message = "Deposit amount must be greater than zero")
	private  Double depositAmount;
	@NotNull(message = "Aadhar number cannot be null")
	@Pattern(regexp="^\\d{12}$", message="aadhar number must be 12 digits")
	private String aadharNumber;

}
