package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("QnA")
public class QnA {
	private int qnaNo;
	private String email;
	private int productNo;
	private String qnaType;		/* 배송, 결제, 상품 ,기타 */
	private String noticeSubject;
	private String content;
	private Date regDate;
	private String qnaDel;
}
