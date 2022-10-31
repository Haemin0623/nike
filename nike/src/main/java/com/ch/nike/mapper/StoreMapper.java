package com.ch.nike.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Store;


@Mapper
public interface StoreMapper {

	List<Store> storelist();


}
