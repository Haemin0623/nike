package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Address;

public interface AddressService {

	List<Address> selectAddr(String email);

}
