package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserOrder")
public class UserOrder {
	private int orderNo;
	private String email;
	private Date orderDate;	
	private int addrNo;
	private String status;

}
