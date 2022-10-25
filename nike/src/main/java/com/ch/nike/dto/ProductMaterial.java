package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProductMaterial")
public class ProductMaterial {
	private int material_no;
	private int product_no;
	private String material;
}
