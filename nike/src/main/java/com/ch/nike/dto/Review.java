package com.ch.nike.dto;

import lombok.Data;

@Data
public class Review {
	private int review_no;
	private int product_no;
	private String email;
	private String content;
	private int star;
	private String review_date;
	private String review_del;
}
