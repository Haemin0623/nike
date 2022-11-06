package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.QnA;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface QnAMapper {

	List<QnA> qnalist();

	List<UserOrder> paginglist(PagingBean pagingbean);


}
