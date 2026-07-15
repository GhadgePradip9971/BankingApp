package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.dto.BalanceDTO;
import com.bank.dto.OpenAccountDTO;
import com.bank.entity.BankAccount;
import com.bank.service.BankService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

	private final BankService bankService;

	@GetMapping("/home")
	public String homePage(Model model) {
		log.info("Home Page Accessed");

		model.addAttribute("totalBalance", bankService.getTotalBalance());
		model.addAttribute("totalAccounts", bankService.getTotalAccounts());

		return "home";
	}
	
	
	@GetMapping("/newacc")
	public String showNewAccountForm(Model model) {
		
		log.info("New Account Form Accessed");
		 model.addAttribute("openAccountDTO", new OpenAccountDTO()); 
		return "openaccount";
	}
	
	@PostMapping("/newacc")
	public String createNewAccount(
	        @Valid @ModelAttribute("openAccountDTO") OpenAccountDTO openAccountDTO,
	        BindingResult result,
	        Model model,
	        RedirectAttributes redirectAttribute) {

	    log.info("Creating new account with accountHolder Name: {}",
	            openAccountDTO.getAccountHolderName());

	    // Validation failed
	    if (result.hasErrors()) {
	        return "openaccount";
	    }

	    try {

	        BankAccount createdAccount = bankService.createAccount(openAccountDTO);

	        redirectAttribute.addFlashAttribute(
	                "success",
	                "Account created successfully! Account Number: "
	                        + createdAccount.getAccountNumber()
	                        + " | Account Holder Name: "
	                        + createdAccount.getAccountHolderName());

	    } catch (Exception e) {

	        log.error("Error creating account: {}", e.getMessage());

	        redirectAttribute.addFlashAttribute("error", e.getMessage());
	    }

	    return "redirect:/bank/newacc";
	}

	
	@GetMapping("/checkbalance")
	public String showBalanceForm(Model model) {
		log.info("Balance Check Form Accessed");
		
	model.addAttribute("balanceDTO", new BalanceDTO());
		return "balance";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
