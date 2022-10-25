package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Cart")
public class Cart {
	private int cartNo;
	private String email;
	private int productNo;
	private int cartQuantity;
}
