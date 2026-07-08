package com.bank.service;

import com.bank.dto.BankAccountDTO;
import com.bank.entity.BankAccount;

public interface BankService {
	
	 BankAccount createAccount(BankAccountDTO bankAccountDTO);

	 
	 
	 
	 // Get Statistics
	    Long getTotalAccounts();
	    Double getTotalBalance();
	 

}