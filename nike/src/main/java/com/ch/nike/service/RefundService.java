package com.ch.nike.service;

import com.ch.nike.dto.Refund;

public interface RefundService {
	String selectName(int orderDetailNo);  
	
	int insertRefund(Refund refund);

	int selectRefundNum();

	void updateRefundChk(int orderDetailNo);
}
