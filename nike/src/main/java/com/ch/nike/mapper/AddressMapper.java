package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Address;

@Mapper
public interface AddressMapper {

	// AccountCon
	List<Address> selectAddr(String email);

	Address getAddr(int orderNo);

	int insertaddress(Address address);
	
	
	
	// UserOrderCon
	List<Address> addrListByEmail(String email);

	int Deleteaddr(int addrNo);

	Address getDefaulAddress(String string);

	void changeAllDefToN(String email);


}
