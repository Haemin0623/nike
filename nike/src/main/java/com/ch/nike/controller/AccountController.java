package com.ch.nike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.nike.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService as;
	
}
