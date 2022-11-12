package com.ch.nike.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Refund;

@Mapper
public interface RefundMapper {
	
	// AccountCon
	Refund selectPro(int orderDetailNo);
	int selectRefundNum();
	void insertRefund(Refund refund);
	void updateRefundChk(int orderDetailNo);
	
	
	
	
	


}
