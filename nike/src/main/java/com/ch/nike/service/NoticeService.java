package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Notice;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;

public interface NoticeService {
	List<Notice> noticelist();

	List<UserOrder> paginglist(PagingBean pagingbean);
}
