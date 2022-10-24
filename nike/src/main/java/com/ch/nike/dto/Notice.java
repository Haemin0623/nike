package com.ch.nike.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Notice {

	private int notice_no;
	private String notice_type;
	private String notice_subject;
	private String content;
	private Date reg_date;
	private int read_count;
	private String del;
}
