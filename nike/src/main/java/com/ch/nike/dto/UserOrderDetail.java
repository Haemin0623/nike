package com.ch.nike.dto;

import lombok.Data;

@Data
public class UserOrderDetail {
	private int order_deatil_no;
	private int order_no;
	private int product_no;
	private int order_quantity;
	private String refund_chk;
}
