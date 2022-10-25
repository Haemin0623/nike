package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Store")
public class Store {
	private int store_no;
	private String store_name;
	private String store_addr;
	private String store_close;
	private String store_open;
	private int store_tel;
}
