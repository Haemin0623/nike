package com.ch.nike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.nike.dto.Member;
import com.ch.nike.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;
	
	@RequestMapping("adminMemberList.do")
	public String adminMemberList(Model model) {
		List<Member> list = as.memberlist();
		model.addAttribute("list",list);
		return "";
	}
}
