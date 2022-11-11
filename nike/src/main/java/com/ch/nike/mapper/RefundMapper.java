package com.ch.nike.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Refund;

@Mapper
public interface RefundMapper {
	
	// AccountCon
	String selectName(int orderDetailNo);
	int selectRefundNum();
	int insertRefund(Refund refund);
	void updateRefundChk(int orderDetailNo);
	
	
	
	
	


}
