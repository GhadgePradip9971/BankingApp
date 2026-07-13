package com.bank.util;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumberGenerator {
	
	public static String generateAccountNumber() {
		// Generate a random 10-digit account number
		
		Random random = new Random();
		
		long accountNumber = 1000000000L + (long)(random.nextDouble() * 9000000000L);
		return "SDFC" + accountNumber;
	}

}
