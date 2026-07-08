package com.bank.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@RequiredArgsConstructor
public class BankAccountDTO {
	private Integer id;
	private String accountNumber;
	private String accountHolderName;
	private String accountType;
	private Double accountBalance;
	private String accountStatus;
	private String aadharNumber;
	private String phoneNumber;
	private String email;
	private String address;
	private String dateOfBirth;
	private String gender;
	private  LocalDateTime createdAt= LocalDateTime.now();
	private LocalDateTime updatedAt;
	private String remarks;
	 
	
}
