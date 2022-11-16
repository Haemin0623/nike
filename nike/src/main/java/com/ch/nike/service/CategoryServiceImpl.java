package com.ch.nike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Category;
import com.ch.nike.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired 
	private CategoryMapper cm;

	@Override
	public Category selectCategory(int categoryNo) {
		return cm.selectCategory(categoryNo);
	}
}
