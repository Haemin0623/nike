package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Notice;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;

public interface NoticeService {
	
	// AdminCon
	// 공지 갯수
	int getTotal();
	// 공지 전체 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);


	
}
