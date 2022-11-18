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
	private int batch;
	private String productPhoto;
	private String color;
	private String productSize;
	
	private int cartNo;
	private String email;
	private int cartQuantity;
	
	private int productDetailNo;
	private int stock;
	private int photoNo;
	private String large;
	private String small;
	private int featurelNo;
	private String feature;
	
	private int productPhotoNo;
	
	// 상품 단가 및 총 결제 금액 천 단위, 표시
	private String unitedPrice;
	private int totalPrice;
}
