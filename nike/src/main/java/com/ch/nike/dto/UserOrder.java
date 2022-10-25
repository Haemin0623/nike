package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserOrder")
public class UserOrder {
	private int order_no;
	private String email;
	private Date order_date;	
	private int addr_no;
	private String status;
}
