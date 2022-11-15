package com.ch.nike.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("member")
public class Member {
	private String email;
	private String name;
	private String password;
	private String memberGender;
	private Date birthday;
	private String memberTel;
	private Date regDate;
	private String memberDel;
	
	//kakao member
	private String profile_nickname;
	private String account_email;
	private String kakao_id;
}
