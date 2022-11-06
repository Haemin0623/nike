package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.UserOrder;

public interface QnAService {
	List<QnA> qnalist();

	List<UserOrder> paginglist(PagingBean pagingbean);
}
