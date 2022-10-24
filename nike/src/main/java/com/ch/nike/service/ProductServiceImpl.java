package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.mapper.ProductDao;

@Service
public class ProductServiceImpl {
	@Autowired
	private ProductDao pd;
	
	
}