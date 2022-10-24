package com.ch.nike.dto;

import lombok.Data;

@Data
public class Product {
	private int product_no;
	private String product_name;
	private int category_no;
	private int price;
	private String detail;
	private String gender;
}
