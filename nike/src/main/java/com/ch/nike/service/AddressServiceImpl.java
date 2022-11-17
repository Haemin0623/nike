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

	// AccountCon
	public List<Address> selectAddr(String email) {
		return am.selectAddr(email);
	}
	public Address getAddr(int orderNo) {
		return am.getAddr(orderNo);
	}
	@Override
	public int insertaddress(Address address) {
		return am.insertaddress(address);
	}
	@Override
	public int Deleteaddr(int addrNo) {
		return am.Deleteaddr(addrNo);
	}
	
	
	// UserOrderCon
	public List<Address> addrListByEmail(String email) {
		return am.addrListByEmail(email);
	}
	@Override
	public Address getDefaulAddress(String string) {
		return am.getDefaulAddress(string);
	}
	@Override
	public void changeAllDefToN(String email) {
		am.changeAllDefToN(email);
		
	}
	
}
