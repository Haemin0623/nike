package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.UserOrder;

public interface QnAService {

	// AdminCon
	// 문의 갯수
	int getTotal();
	// 전체 문의 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);

}
