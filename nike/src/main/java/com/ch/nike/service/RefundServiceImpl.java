package com.ch.nike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Refund;
import com.ch.nike.mapper.RefundMapper;

@Service
public class RefundServiceImpl implements RefundService {
	@Autowired
	private RefundMapper rm;
	
	public String selectName(int orderDetailNo) {
		return rm.selectName(orderDetailNo);
	}
	public int insertRefund(Refund refund) {
		return rm.insertRefund(refund);
	}

	public int selectRefundNum() {
		return rm.selectRefundNum();
	}

	public void updateRefundChk(int orderDetailNo) {
		rm.updateRefundChk(orderDetailNo);
	}
}
