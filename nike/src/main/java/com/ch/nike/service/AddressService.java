package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Address;

public interface AddressService {
	
	// AccountCon
	// 회원의 모든 배송지 조회
	List<Address> selectAddr(String email);
	// 해당 주문번호에 대한 배송지
	Address getAddr(int orderNo);

}
