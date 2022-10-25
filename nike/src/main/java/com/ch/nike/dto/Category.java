package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Category")
public class Category {
	private int category_no;
	private int large;
	private int small;

}
