package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ReviewPhoto")
public class ReviewPhoto {
	private int reviewPhotoNo;
	private int reviewNo;
	private String reviewPhoto;
}
