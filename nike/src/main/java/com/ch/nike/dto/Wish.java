package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Wish")
public class Wish {
	private int wishNo;
	private int productNo;
	private String email;
	private String color;
	
	//조인용
	private String productName;
	private String productPhoto;
	private int price;
}
