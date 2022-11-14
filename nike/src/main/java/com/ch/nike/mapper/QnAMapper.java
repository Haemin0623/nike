package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface QnAMapper {

	// AdminCon
	int getTotal(PagingBean pagingbean);
	List<UserOrder> paginglist(PagingBean pagingbean);
	QnA selectqna(QnA qna);
	int adminQnaStatusUpdate(QnA qna);
	int adminqnareply(QnA qna);
	
	// AccountCon
	List<QnA> qnaListByEmail(String email);
	int deleteQna(int qnaNo);
	QnA selectrefNo(QnA qna);
	int updatestatus(QnA qna);

}
