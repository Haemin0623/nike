package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Member;
import com.ch.nike.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper am;

	@Override
	public List<Member> memberlist() {
		return am.memberlist();
	}
}
