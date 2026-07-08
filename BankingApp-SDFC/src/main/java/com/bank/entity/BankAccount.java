package com.bank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankAccount {
@GeneratedValue(
		strategy = jakarta.persistence.GenerationType.IDENTITY)
@Id
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
