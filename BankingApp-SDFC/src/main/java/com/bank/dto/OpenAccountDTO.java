package com.bank.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor
public class OpenAccountDTO {

	@NotBlank(message = "Account holder name is required")
	private String accountHolderName;
	@NotBlank(message = "Account type is required")
	private String accountType;
	@NotNull(message = "Account balance is required")
	@DecimalMin(message = "Account balance must be greater than or equal to 500", value = "500.0")
	private Double accountBalance;
	@Pattern(regexp = "\\d{12}", message = "Aadhar number must be a 12-digit number")
	private String aadharNumber;
	@Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
	private String phoneNumber;
	@Email (message = "Email should be valid")
	private String email;
	@NotBlank(message = "Address is required")
	private String address;
	@NotBlank(message = "Date of birth is required")
	private String dateOfBirth;
	@NotBlank (message = "Gender is required")
	private String gender;

	private String remarks;

}
