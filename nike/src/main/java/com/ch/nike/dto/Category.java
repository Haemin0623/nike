package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Category")
public class Category {
	private int categoryNo;
	private String large;
	private String small;

}
