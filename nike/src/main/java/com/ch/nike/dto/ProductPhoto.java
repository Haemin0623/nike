package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProductPhoto")
public class ProductPhoto {
	private int photo_no;
	private int product_no;
	private String product_photo;
	private int batch;				// 1(썸네일) / 2(머리) / 3(몸통)

}
