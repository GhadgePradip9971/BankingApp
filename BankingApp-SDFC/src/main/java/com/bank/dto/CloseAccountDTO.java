package com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CloseAccountDTO {

	@NotBlank(message="Account number not be null")
	private String accountNumber;
	@NotBlank(message="aadhar Number not be null")
	@Pattern(regexp="^\\d{12}$", message="aadhar number must be 12 digits")
	private String aadharNumber;
}
