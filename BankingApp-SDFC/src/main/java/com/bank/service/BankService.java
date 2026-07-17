package com.bank.service;

import com.bank.dto.DepositDTO;
import com.bank.dto.OpenAccountDTO;
import com.bank.dto.TransferDTO;
import com.bank.dto.WithdrawDTO;
import com.bank.entity.BankAccount;

public interface BankService {
	
	 BankAccount createAccount(OpenAccountDTO openAccountDTO);
	 
	Double checkBalance(String accountNumber, String phoneNumber, String aadharNumber);
	BankAccount deposit(DepositDTO depositDTO);
	BankAccount withdraw(WithdrawDTO withdrawDTO);
	BankAccount transfer(TransferDTO transferDTO);

	
	
	 
	 
	 
	 
	 
	 // Get Statistics
	    Long getTotalAccounts();
	    Double getTotalBalance();

	 

}