package com.ch.nike.dto;

import lombok.Data;

@Data
public class Refund {
	private int refund_no;
	private int order_deatil_no;
	private String reason;
	private String refund_photo;
}
