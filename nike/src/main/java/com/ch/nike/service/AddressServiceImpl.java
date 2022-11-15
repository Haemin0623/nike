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
<<<<<<< HEAD
	@Override
	public int Deleteaddr(int addrNo) {
		return am.Deleteaddr(addrNo);
=======

	
	
	// UserOrderCon
	public List<Address> addrListByEmail(String email) {
		return am.addrListByEmail(email);
>>>>>>> 75f4604 (카트리스트 상세정보 표기, 사이즈 변경, 수량 변경, 주문결제(paymentAPI) 완료)
	}
	
}
