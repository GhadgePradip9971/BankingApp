package com.bank.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BalanceDTO {
	
		@NotNull(message = "Account number cannot be null")
	private String accountNumber;

}
