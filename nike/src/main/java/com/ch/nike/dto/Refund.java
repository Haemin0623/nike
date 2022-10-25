package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Refund")
public class Refund {
	private int refundNo;
	private int orderDeatilNo;
	private String reason;
	private String refundPhoto;
}
