package com.ch.nike.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Wish;
import com.ch.nike.service.CartService;
import com.ch.nike.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService ws;
	@Autowired
	private CartService cs;
	
	
}
