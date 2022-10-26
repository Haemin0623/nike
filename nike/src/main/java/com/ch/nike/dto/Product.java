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
	//조인용
	private int batch;
	private String productPhoto;
	
}
