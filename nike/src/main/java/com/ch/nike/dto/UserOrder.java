package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("UserOrder")
public class UserOrder {
	private int orderNo;
	private String email;
	private Date orderDate;	
	private int addrNo;
	private String status;

//조인용 mypage - orderList에서 사용예정 by선희
	//product
	private int productNo;
	private String productName;
	private int categoryNo;
	private int price;
	private String detail;
	private String gender;
	
	//productphoto
	private int batch;
	private String productPhoto;
	private String color;
	private String productSize;
	
	//address
	private String addrName;
	private int tel;
	private String roadaddress;
	private String jibunaddress;
	private int zonecode;
	private String detailaddress;
	
	//userorderdetail
	private int orderDetailNo;
	private int orderQuantity;
	private String refundChk;		// N(default, 신청안함) / A(환불진행중) / Y(환불완료) / D(환불거절)
	private int productDetailNo;
	
	//productDetail
	private int stock;
	
	private int count;

	
	
}
