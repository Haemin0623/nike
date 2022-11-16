package com.ch.nike.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.nike.dto.Category;

@Mapper
public interface CategoryMapper {

	Category selectCategory(int categoryNo);


}
