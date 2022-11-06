package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface StoreMapper {

	List<Store> storelist();

	List<UserOrder> paginglist(PagingBean pagingbean);


}
