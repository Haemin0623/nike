package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Review")
public class Review {
	private int reviewNo;
	private int productNo;
	private String email;
	private String content;
	private int star;
	private String reviewDate;
	private String reviewDel;
}
