package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ReviewPhoto")
public class ReviewPhoto {
	private int review_photo_no;
	private int review_no;
	private String review_photo;
}
