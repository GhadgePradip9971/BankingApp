package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/bank")
public class BankController {
	
	@GetMapping("/home")
	public String homePage() {
		log.info("BankController: homePage() method called");
		return "home";
	}
	
	
	
	

}
