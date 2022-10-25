package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Address")
public class Address {
	private int addr_no;
	private String email;
	private String addr_name;
	private int tel;
	private String roadaddress;
	private String jibunaddress;
	private int zonecode;
	private String detailaddress;
}
