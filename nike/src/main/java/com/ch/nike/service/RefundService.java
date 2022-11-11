package com.ch.nike.service;

import com.ch.nike.dto.Refund;

public interface RefundService {
	
	// AccountCon
	// 주문상세에서 해당 상품의 이름 조회
	String selectName(int orderDetailNo);
	// 환불 테이블 최대번호
	int selectRefundNum();
	// 환불 추가
	int insertRefund(Refund refund);
	// 주문상세에서 환불여부 변경
	void updateRefundChk(int orderDetailNo);
	
	


}
