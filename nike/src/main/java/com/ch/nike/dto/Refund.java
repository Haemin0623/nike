package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("Refund")
public class Refund {
	private int refundNo;
	private int orderDetailNo;
	private String reason;
	private String refundPhoto;
	// upload용
	private MultipartFile file;
	
	//product
	private String productName;
	private int categoryNo;
	private int price;
	private String detail;
	private String gender;
	
	// productDetail
	private int productDetailNo;
	private int productNo;
	private String productSize;
	private String color;
	private int stock;
	
	//userOrderDetail
	private int orderNo;
	private int orderQuantity;
	private String refundChk;		// N(default, 신청안함) / A(환불진행중) / Y(환불완료) / D(환불거절)
}
