package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.UserOrder;
import com.ch.nike.mapper.QnAMapper;

@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
	private QnAMapper qm;

	// AdminCon
	@Override
	public int getTotal(PagingBean pagingbean) {
		return qm.getTotal(pagingbean);
	}
	@Override
	public List<UserOrder> paginglist(PagingBean pagingbean) {
		return qm.paginglist(pagingbean);
	}

}