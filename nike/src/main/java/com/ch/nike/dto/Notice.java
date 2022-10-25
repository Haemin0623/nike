package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Notice")
public class Notice {

	private int noticeNo;
	private String noticeType;
	private String noticeSubject;
	private String content;
	private Date regDate;
	private int readCount;
	private String del;
}
