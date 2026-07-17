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
import com.bank.dto.DepositDTO;
import com.bank.dto.OpenAccountDTO;
import com.bank.dto.WithdrawDTO;
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
	public String createNewAccount(@Valid @ModelAttribute("openAccountDTO") OpenAccountDTO openAccountDTO,
			BindingResult result, Model model, RedirectAttributes redirectAttribute) {

		log.info("Creating new account with accountHolder Name: {}", openAccountDTO.getAccountHolderName());

		// Validation failed
		if (result.hasErrors()) {
			return "openaccount";
		}

		try {

			BankAccount createdAccount = bankService.createAccount(openAccountDTO);

			redirectAttribute.addFlashAttribute("success",
					"Account created successfully! Account Number: " + createdAccount.getAccountNumber()
							+ " | Account Holder Name: " + createdAccount.getAccountHolderName());

		} catch (Exception e) {

			log.error("Error creating account: {}", e.getMessage());

			redirectAttribute.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/bank/newacc";
	}

	@GetMapping("/checkbalance")
	public String showBalanceForm(Model model) {
		log.info("Balance Check Form Accessed");
		if (!model.containsAttribute("balanceDTO")) {
			model.addAttribute("balanceDTO", new BalanceDTO());
		}
		return "balance";
	}

	@PostMapping("/checkbalance")
	public String checkBalance(@Valid @ModelAttribute("balanceDTO") BalanceDTO balanceDTO, BindingResult result,
			Model model, RedirectAttributes redirectAttribute) {

		log.info("Checking balance for account number: {}", balanceDTO.getAccountNumber());

		// Validation failed
		if (result.hasErrors()) {
			return "balance";
		}

		try {

			double balance = bankService.checkBalance(balanceDTO.getAccountNumber(), balanceDTO.getPhoneNumber(),
					balanceDTO.getAadharNumber());

			redirectAttribute.addFlashAttribute("success", "Balance fetched successfully!");
			redirectAttribute.addFlashAttribute("accountNumber", balanceDTO.getAccountNumber());
			redirectAttribute.addFlashAttribute("balance", balance);

		} catch (Exception e) {

			log.error("Error checking balance: {}", e.getMessage());

			redirectAttribute.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/bank/checkbalance";
	}

	@GetMapping("/deposit")
	public String showDepositForm(Model model) {
		log.info("Deposit Form Accessed");
		if (!model.containsAttribute("deposit")) {
			model.addAttribute("depositDTO", new DepositDTO());
		}
		return "depositform";
	}

	@PostMapping("/deposit")
	public String deposit(@Valid @ModelAttribute("depositDTO") DepositDTO depositDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttribute) {

		log.info("Depositing amount: {} to account number: {}", depositDTO.getDepositAmount(),
				depositDTO.getAccountNumber());

		// Validation failed
		if (result.hasErrors()) {
			return "depositform";
		}

		try {

			BankAccount updatedAccount = bankService.deposit(depositDTO);

			redirectAttribute.addFlashAttribute("success",
					"Deposit successful! New Balance: ₹" + updatedAccount.getAccountBalance());

			redirectAttribute.addFlashAttribute("accountHolderName", updatedAccount.getAccountHolderName());

			redirectAttribute.addFlashAttribute("accountNumber", updatedAccount.getAccountNumber());

			redirectAttribute.addFlashAttribute("aadharNumber", updatedAccount.getAadharNumber());

			redirectAttribute.addFlashAttribute("depositAmount", depositDTO.getDepositAmount());

			redirectAttribute.addFlashAttribute("updatedBalance", updatedAccount.getAccountBalance());

		} catch (Exception e) {

			log.error("Error during deposit: {}", e.getMessage());

			redirectAttribute.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/bank/deposit";
	}

	@GetMapping("/withdraw")
	public String withdrawform(Model model) {
		log.info("withdraw form accessed!!");

		model.addAttribute("withdrawDTO", new WithdrawDTO());
		return "withdrawform";
	}

	@PostMapping("/withdraw")
	public String withdraw(@Valid @ModelAttribute("withdrawDTO") WithdrawDTO withdrawDTO, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {

		log.info("Depositing amount: {} to account number: {}", withdrawDTO.getWithdrawAmount(),
				withdrawDTO.getAccountNumber());

		if (result.hasErrors()) {
			return "withdrawform";
		}
		try {

		BankAccount bankAccount = bankService.withdraw(withdrawDTO);
		redirectAttributes.addFlashAttribute("success",
				"₹" + withdrawDTO.getWithdrawAmount() + " withdrawn successfully.");

		redirectAttributes.addFlashAttribute("accountHolderName", bankAccount.getAccountHolderName());
		redirectAttributes.addFlashAttribute("aadharNumber", bankAccount.getAadharNumber());


		redirectAttributes.addFlashAttribute("accountNumber", bankAccount.getAccountNumber());

		redirectAttributes.addFlashAttribute("remainingBalance", bankAccount.getAccountBalance());
		redirectAttributes.addFlashAttribute("withdrawAmmount", withdrawDTO.getWithdrawAmount());
		}

		catch (Exception e) {

			log.error("Error during deposit: {}", e.getMessage());

			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}
		return "redirect:/bank/withdraw";
	}

}
