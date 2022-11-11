package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Notice;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper nm;

	// AdminCon
	@Override
	public int getTotal() {
		return nm.getTotal();
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return nm.paginglist(pagingbean);
	}

	

	
}