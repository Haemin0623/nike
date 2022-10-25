package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserOrderDetail")
public class UserOrderDetail {
	private int order_deatil_no;
	private int order_no;
	private int product_no;
	private int order_quantity;
	private String refund_chk;
}
