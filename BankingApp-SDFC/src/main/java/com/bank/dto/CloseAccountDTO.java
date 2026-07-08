package com.bank.dto;

import lombok.Data;

@Data
public class CloseAccountDTO {

	private String accountNumber;
	private String reasonForClosure;
}
