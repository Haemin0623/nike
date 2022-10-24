package com.ch.nike.dto;

import lombok.Data;

@Data
public class ProductDetail {
	private int product_detail_no;
	private int product_no;
	private String product_size;
	private String color;
	private int stock;

}
