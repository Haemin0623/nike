package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("ProductPhoto")
public class ProductPhoto {

	private int photoNo;
	private int productNo;
	private String productPhoto;
	private int batch;				// 1(썸네일) / 2(머리) / 3(몸통)

	private String color;

	private String fileName;

}
