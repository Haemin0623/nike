package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Notice;
import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.UserOrder;

public interface NoticeService {
	
	// AdminCon
	// 공지 갯수
	int getTotal();
	// 공지 전체 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);
	
	//공지 등록 by수인
	int insertNotice(Notice notice);
	
	//공지상세페이지
	Notice selectNotice(int noticeNo);
	
	//공지 수정 by 수인
	int updateNotice(Notice notice);
	
	//공지 삭제 by 수인
	int deleteNotice(int noticeNo);
	
	// 고객센터 - 모든공지 by 수인
	List<Notice> selectNoticeForHelp();
	
	// 고객센터 - 검색 by수인
	List<Notice> searchNotice(PagingBean pagingbean);
	int getTotal2(PagingBean pagingbean); //페이징


	
}
