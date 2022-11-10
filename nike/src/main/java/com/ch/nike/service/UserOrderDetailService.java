package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrderDetail;

public interface UserOrderDetailService {

	int getTotal();

	List<UserOrderDetail> paginglist(PagingBean pagingbean);


}
