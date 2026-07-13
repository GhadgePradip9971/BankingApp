package com.bank.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor
public class OpenAccountDTO {
	private String accountHolderName;
	private String accountType;
	private Double accountBalance;
	private String aadharNumber;
	private String phoneNumber;
	private String email;
	private String address;
	private String dateOfBirth;
	private String gender;
	
	private String remarks;
	 
	
}
