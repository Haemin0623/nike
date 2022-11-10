package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ProductMaterial")
public class ProductFeature {
	private int featurelNo;
	private int productNo;
	private String feature;
}
