package com.ch.nike.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper am;






}

