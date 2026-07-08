package com.bank.dto;

import lombok.Data;

@Data

public class DepositDTO {
	
	public String accountNumber;
	public Double depositAmount;
	public String description;

}
