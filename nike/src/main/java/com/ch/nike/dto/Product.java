package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Product")
public class Product {
	private int product_no;
	private String product_name;
	private int category_no;
	private int price;
	private String detail;
	private String gender;
	private int batch;//조인용
	
}
