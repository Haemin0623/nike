package com.ch.nike.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Refund;

@Mapper
public interface RefundMapper {
	String selectName(int orderDetailNo);
	
	int selectRefundNum(int refundNo);

	int insertRefund(Refund refund);

	void updateRefundChk(int orderDetailNo);
}
