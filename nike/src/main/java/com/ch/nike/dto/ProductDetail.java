package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProductDetail")
public class ProductDetail {
	private int product_detail_no;
	private int product_no;
	private String product_size;
	private String color;
	private int stock;

}
