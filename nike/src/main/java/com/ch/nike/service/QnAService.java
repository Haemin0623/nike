package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.UserOrder;

public interface QnAService {

	// AdminCon
	// 문의 갯수
	int getTotal(PagingBean pagingbean);
	// 전체 문의 조회(페이징)
	List<UserOrder> paginglist(PagingBean pagingbean);
	QnA selectqna(QnA qna);
	int adminQnaStatusUpdate(QnA qna);
	int adminqnareply(QnA qna);
	
	// AccountCon
	// 해당 회원의 qnaList 불러오기
	List<QnA> qnaListByEmail(String email);
	// qna 삭제하기
	int deleteQna(int qnaNo);
	QnA selectrefNo(QnA qna);
	int updatestatus(QnA qna);

}
