package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserOrderDetail")
public class UserOrderDetail {
	private int orderDetailNo;
	private int orderNo;
	private int productDetailNo;
	private int orderQuantity;
	private String refundChk;		// N(default, 신청안함) / A(환불진행중) / Y(환불완료) / D(환불거절)
	
	//조인용
	private String productName;
}
