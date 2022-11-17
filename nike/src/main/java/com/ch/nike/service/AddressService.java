package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Address;

public interface AddressService {
	
	// AccountCon
	// 회원의 모든 배송지 조회
	List<Address> selectAddr(String email);
	// 해당 주문번호에 대한 배송지
	Address getAddr(int orderNo);
	int insertaddress(Address address);
	int Deleteaddr(int addrNo);
	
	// UserOrderCon
	// 배송지 주소 리스트
	List<Address> addrListByEmail(String email);
	Address getDefaulAddress(String string);
	void changeAllDefToN(String email);

}
