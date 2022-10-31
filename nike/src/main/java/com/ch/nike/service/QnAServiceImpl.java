package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.QnA;
import com.ch.nike.mapper.QnAMapper;

@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
	private QnAMapper qm;

	@Override
	public List<QnA> qnalist() {
		return qm.qnalist();
	}
}