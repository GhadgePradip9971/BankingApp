package com.bank.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bank.dto.DepositDTO;
import com.bank.dto.OpenAccountDTO;
import com.bank.entity.BankAccount;
import com.bank.exception.AccountInactiveException;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.CustomerAlreadyExistsException;
import com.bank.exception.InvalidAmountException;
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

		if (bankRepository.existsByAadharNumber(openAccountDTO.getAadharNumber())) {
			throw new CustomerAlreadyExistsException(
					"Customer with Aadhar number " + openAccountDTO.getAadharNumber() + " already exists.");
		}

		log.info("Creating new account for : {}", openAccountDTO.getAccountHolderName());

		// Generate a unique account number
		String accountNumber;

		do {
			accountNumber = accountNumberGenerator.generateAccountNumber();
		} while (bankRepository.existsByAccountNumber(accountNumber));

		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber(accountNumber);
		bankAccount.setAccountHolderName(openAccountDTO.getAccountHolderName());
		bankAccount.setAccountType(openAccountDTO.getAccountType());
		bankAccount.setAccountBalance(openAccountDTO.getAccountBalance());
		bankAccount.setAccountStatus("ACTIVE");
		bankAccount.setAadharNumber(openAccountDTO.getAadharNumber());
		bankAccount.setPhoneNumber(openAccountDTO.getPhoneNumber());
		bankAccount.setEmail(openAccountDTO.getEmail());
		bankAccount.setAddress(openAccountDTO.getAddress());
		bankAccount.setDateOfBirth(openAccountDTO.getDateOfBirth());
		bankAccount.setGender(openAccountDTO.getGender());
		bankAccount.setCreatedAt(LocalDateTime.now());
		bankAccount.setUpdatedAt(LocalDateTime.now());
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

	@Override
	public Double checkBalance(String accountNumber, String phoneNumber, String aadharNumber) {
		
		log.info("Checking balance for account number: {}", accountNumber);
		log.info("Checking balance for phone number: {}", phoneNumber);
		log.info("Checking balance for aadhar number: {}", aadharNumber);
		
		
		BankAccount bankAccount = bankRepository.findByAccountNumberAndPhoneNumberAndAadharNumber(accountNumber, phoneNumber, aadharNumber)
	            .orElseThrow(() -> new AccountNotFoundException("\"Invalid Account Number, Phone Number or Aadhaar Number.\""));		

	    if (!"ACTIVE".equalsIgnoreCase(bankAccount.getAccountStatus())) {
	        throw new AccountInactiveException("Your account is inactive.");
	    }

	    return bankAccount.getAccountBalance();
		
		
	}

	@Override
	public BankAccount deposit(DepositDTO depositDTO) {
		log.info("Depositing amount: {} to account number: {}", depositDTO.getDepositAmount(), depositDTO.getAccountNumber());
		log.info("Depositing amount aadhar number: {}", depositDTO.getAadharNumber());
		
		
		


		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
