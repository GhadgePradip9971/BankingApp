package com.bank.repositiory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.entity.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Integer> {
	
	Optional<BankAccount> findByAccountNumberAndPhoneNumberAndAadharNumber(String accountNumber,String phoneNumber,String aadharNumber);
	
	List<BankAccount> findByAccountHolderNameContainingIgnoreCase(String accountHolderName);
	
	boolean existsByAccountNumber(String accountNumber);
	boolean existsByAadharNumber(String aadharNumber);
	
	@Query ("SELECT SUM(b.accountBalance) FROM BankAccount b WHERE b.accountStatus = 'ACTIVE'")
	Double getTotalBalance();
	
	long countByAccountStatus(String accountStatus);
	

}
