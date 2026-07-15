package com.bank.service;

import com.bank.dto.OpenAccountDTO;
import com.bank.entity.BankAccount;

public interface BankService {
	
	 BankAccount createAccount(OpenAccountDTO openAccountDTO);
	 
	 Double checkBalance(String accountNumber);

	 
	 
	 
	 
	 
	 // Get Statistics
	    Long getTotalAccounts();
	    Double getTotalBalance();
	 

}