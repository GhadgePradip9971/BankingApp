package com.bank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class DepositDTO {
	
	@NotNull(message = "Account number cannot be null")
	public String accountNumber;
	@NotNull(message = "Deposit amount cannot be null")
	public Double depositAmount;
	@NotNull(message = "Aadhar number cannot be null")
	@Pattern(regexp="^\\d{12}$", message="aadhar number must be 12 digits")
	public String aadharNumber;

}
