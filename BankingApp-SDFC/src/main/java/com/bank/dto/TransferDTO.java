package com.bank.dto;

import lombok.Data;

@Data
public class TransferDTO {
	private String fromAccountNumber;
	private String toAccountNumber;
	private Double transferAmount;
	private String description;

}
