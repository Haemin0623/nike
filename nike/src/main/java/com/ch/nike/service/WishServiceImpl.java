package com.ch.nike.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Wish;
import com.ch.nike.mapper.WishMapper;

@Service
public class WishServiceImpl implements WishService{
	@Autowired
	private WishMapper wm;

	public Wish selectByEmail(Wish wish) {
		return wm.selectByEmail(wish);
	}

	public int insert(Wish wish) {
		return wm.insert(wish);
	}

	public void delete(int wishNo) {
		wm.delete(wishNo);
	}

	@Override
	public List<Wish> wishList(String email) {
		return wm.wishList(email);
	}


}