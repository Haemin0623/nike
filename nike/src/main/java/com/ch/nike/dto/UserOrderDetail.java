package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserOrderDetail")
public class UserOrderDetail {
	private int orderDeatilNo;
	private int orderNo;
	private int productNo;
	private int orderQuantity;
	private String refundChk;
}
