package com.ch.nike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Wish;
import com.ch.nike.mapper.WishMapper;

@Service
public class WishServiceImpl implements WishService{
	@Autowired
	private WishMapper wm;

	@Override
	public List<Wish> wishselect(String email) {
		return wm.wishselect(email);
	}
}