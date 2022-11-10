package com.ch.nike.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.nike.dto.Product;
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
	public List<Wish> selectWish(String email) {
		return wm.selectWish(email);
	}

	public Product selectWishThum(int productNo) {
		return wm.selectWishThum(productNo);
	}
	public Wish selectWishResult(String email, int productNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("productNo", productNo);
		return wm.selectWishResult(map);
	}
	public void deleteWish(String email, int productNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("productNo", productNo);
		wm.deleteWish(map);
	}
	public int selectCount() {
		return wm.selectCount();
	}
	public void addWish(String email, int productNo, int wishNo) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("productNo", productNo);
		map.put("wishNo", wishNo);
		wm.addWish(map);
	}
}