package com.ch.nike.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Wish;
import com.ch.nike.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService ws;
	@RequestMapping("/product/addWish.do")
	public String addWish() {
		
		return "product/addWish";
	}
}
