package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Address;
import com.ch.nike.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper am;

	public List<Address> selectAddr(String email) {
		return am.selectAddr(email);
	}
	
}
