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
}
