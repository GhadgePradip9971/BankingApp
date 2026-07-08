package com.bank.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bank.dto.BankAccountDTO;
import com.bank.entity.BankAccount;
import com.bank.exception.DuplicateAccountNumberException;
import com.bank.repositiory.BankRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

	private final BankRepository bankRepository;

	@Override
	public BankAccount createAccount(BankAccountDTO bankAccountDTO) {
		log.info("creating new account with account number: {}", bankAccountDTO.getAccountHolderName());

		if (bankRepository.existsByAccountNumber(bankAccountDTO.getAccountNumber())) {

			throw new DuplicateAccountNumberException(
					"Account number already exists: " + bankAccountDTO.getAccountNumber());
		}

		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
		bankAccount.setAccountHolderName(bankAccountDTO.getAccountHolderName());
		bankAccount.setAccountBalance(bankAccountDTO.getAccountBalance());
		bankAccount.setAccountStatus(bankAccountDTO.getAccountStatus());
		bankAccount.setAadharNumber(bankAccountDTO.getAadharNumber());
		bankAccount.setPhoneNumber(bankAccountDTO.getPhoneNumber());
		bankAccount.setEmail(bankAccountDTO.getEmail());
		bankAccount.setAddress(bankAccountDTO.getAddress());
		bankAccount.setDateOfBirth(bankAccountDTO.getDateOfBirth());
		bankAccount.setGender(bankAccountDTO.getGender());
		bankAccount.setCreatedAt(LocalDateTime.now());
		bankAccount.setUpdatedAt(bankAccountDTO.getUpdatedAt());
		bankAccount.setRemarks(bankAccountDTO.getRemarks());

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
