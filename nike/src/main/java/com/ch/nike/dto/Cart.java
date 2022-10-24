package com.ch.nike.dto;

import lombok.Data;

@Data
public class Cart {
	private int cart_no;
	private String email;
	private int product_no;
	private int cart_quantity;
}
