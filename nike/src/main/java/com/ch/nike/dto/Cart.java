package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Cart")
public class Cart {
	private int cart_no;
	private String email;
	private int product_no;
	private int cart_quantity;
}
