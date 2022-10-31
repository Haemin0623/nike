package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Notice;
import com.ch.nike.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper nm;

	@Override
	public List<Notice> noticelist() {
		return nm.noticelist();
	}
}