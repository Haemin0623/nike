package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Address")
public class Address {
	private int addrNo;
	private String email;
	private String addrName;
	private String tel;
	private String roadaddress;
	private String jibunaddress;
	private int zonecode;
	private String detailaddress;
	
	//UserOrder
	private int orderNo;
	private Date orderDate;	
	private String status;
}
