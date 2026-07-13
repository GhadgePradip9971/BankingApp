package com.bank.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bank.dto.OpenAccountDTO;
import com.bank.entity.BankAccount;
import com.bank.repositiory.BankRepository;
import com.bank.util.AccountNumberGenerator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

	private final BankRepository bankRepository;
	
	
	private final AccountNumberGenerator accountNumberGenerator;
	

	@Override
	public BankAccount createAccount(OpenAccountDTO openAccountDTO) {
		  log.info("Creating new account for : {}", openAccountDTO.getAccountHolderName());

		    // Generate a unique account number
		    String accountNumber;

		    do {
		        accountNumber = accountNumberGenerator.generateAccountNumber();
		    } while (bankRepository.existsByAccountNumber(accountNumber));

		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber(accountNumber);
		bankAccount.setAccountHolderName(openAccountDTO.getAccountHolderName());
		bankAccount.setAccountBalance(openAccountDTO.getAccountBalance());
		bankAccount.setAccountStatus("ACTIVE");
		bankAccount.setAadharNumber(openAccountDTO.getAadharNumber());
		bankAccount.setPhoneNumber(openAccountDTO.getPhoneNumber());
		bankAccount.setEmail(openAccountDTO.getEmail());
		bankAccount.setAddress(openAccountDTO.getAddress());
		bankAccount.setDateOfBirth(openAccountDTO.getDateOfBirth());
		bankAccount.setGender(openAccountDTO.getGender());
		bankAccount.setCreatedAt(LocalDateTime.now());
		bankAccount.setUpdatedAt(null);
		bankAccount.setRemarks(openAccountDTO.getRemarks());
		
		log.info("Saving new account with accountNumber: {}", bankAccount.getAccountNumber());

		return bankRepository.save(bankAccount);
	}

	@Override
	public Long getTotalAccounts() {
		// TODO Auto-generated method stub
		return bankRepository.count();
	}

	@Override
	public Double getTotalBalance() {
		// TODO Auto-generated method stub
		return bankRepository.getTotalBalance();
	}

}
