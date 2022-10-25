package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Wish")
public class Wish {
	private int wish_no;
	private int product_no;
	private String email;

}
