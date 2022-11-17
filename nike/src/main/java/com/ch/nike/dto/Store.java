package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Store")
public class Store {
	private int storeNo;
	private String storeName;
	private String storeAddr;
	private String storeClose;
	private String storeOpen;
	private String storeTel;
	private float latitude;
	private float longitude;
	
	private String search;
}
