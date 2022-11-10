package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("Review")
public class Review {
	private int reviewNo;
	private int productNo;
	private String email;
	private String content;
	private float star;
	private String color;
	private String reviewDate;
	private String reviewDel;
	
	// upload용
	private MultipartFile file;
	//조인용
	private int reviewPhotoNo;
	private String reviewPhoto;
	private String productName;
	
}
