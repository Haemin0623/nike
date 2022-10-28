package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Product")
public class Product {
	private int productNo;
	private String productName;
	private int categoryNo;
	private int price;
	private String detail;
	private String gender;

	// 조인용
	// 이렇게 해도 되는데 ProductPhoto 클래스 자체를 넣어도 될듯??
	// private ProductPhoto productPhoto	by 해민
	private int batch;
	private String productPhoto;
	private String color;
	private String productSize;
	private int stock;
	private String productDetailNo;

}
