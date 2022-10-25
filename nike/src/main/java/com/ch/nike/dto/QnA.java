package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("QnA")
public class QnA {
	private int qna_no;
	private String email;
	private int product_no;
	private String qna_type;		/* 배송, 결제, 상품 ,기타 */
	private String notice_subject;
	private String content;
	private Date reg_date;
	private String qna_del;
}
