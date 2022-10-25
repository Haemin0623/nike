package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProductDetail")
public class ProductDetail {
	private int productDetailNo;
	private int productNo;
	private String productSize;
	private String color;
	private int stock;

}
