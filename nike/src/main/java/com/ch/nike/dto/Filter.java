package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("Filter")
public class Filter {
	private String[] gender;
	private String[] color;
	private int[] price;
	private String[] productSize;
}
