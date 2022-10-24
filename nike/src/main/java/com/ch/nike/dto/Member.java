package com.ch.nike.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private String email;
	private String name;
	private String password;
	private String member_gender;
	private Date date;
	private int member_tel;
	private Date reg_date;
	private String member_del;
}
