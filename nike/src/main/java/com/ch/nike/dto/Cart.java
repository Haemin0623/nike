package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Cart")
public class Cart {
	private int cartNo;
	private String email;
	private int productDetailNo;
	private int cartQuantity;
	
	// 조인용
	private int productNo;
	private String productSize;
	private String color;
	private int stock;
}
