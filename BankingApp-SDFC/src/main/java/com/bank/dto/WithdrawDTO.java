package com.bank.dto;

import lombok.Data;

@Data
public class WithdrawDTO {
	private String accountNumber;
	private Double withdrawAmount;
	private String description;

}
