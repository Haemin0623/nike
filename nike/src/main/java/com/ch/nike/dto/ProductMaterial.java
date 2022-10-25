package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProductMaterial")
public class ProductMaterial {
	private int materialNo;
	private int productNo;
	private String material;
}
