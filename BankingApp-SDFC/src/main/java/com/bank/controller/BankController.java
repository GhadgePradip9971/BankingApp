package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.dto.BankAccountDTO;
import com.bank.entity.BankAccount;
import com.bank.service.BankService;

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
		 model.addAttribute("bankAccountDTO", new BankAccountDTO()); 
		return "openaccount";
	}
	
	@PostMapping("/newacc")
	public String createNewAccount(@ModelAttribute  BankAccountDTO bankAccountDTO, Model model,  RedirectAttributes redirectAttribute) {
		log.info("Creating new account with accountHolder Name: {}", bankAccountDTO.getAccountHolderName());

		try {
			BankAccount createdAccount = bankService.createAccount(bankAccountDTO);
			 redirectAttribute.addFlashAttribute("success", 
		                "Account created! Number: " + createdAccount.getAccountNumber());
			 } catch (Exception e) {
			log.error("Error creating account: {}", e.getMessage());
			 redirectAttribute.addFlashAttribute("error", e.getMessage());
	            return "redirect:/bank/newacc";
		}

		return "openaccount";
	}

}
