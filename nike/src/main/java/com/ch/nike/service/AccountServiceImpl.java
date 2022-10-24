package com.ch.nike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper am;
}
