package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Refund")
public class Refund {
	private int refund_no;
	private int order_deatil_no;
	private String reason;
	private String refund_photo;
}
