package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.PagingBean;
import com.ch.nike.dto.Store;
import com.ch.nike.dto.UserOrder;


@Mapper
public interface StoreMapper {

	// AdminCon
	int getTotal();
	List<Store> paginglist(PagingBean pagingbean);
	Store selectstoreno(int storeNo);
	List<Store> storelist(Store store);
	int storedelete(int storeNo);
	int adminstoreinsert(Store store);

}
