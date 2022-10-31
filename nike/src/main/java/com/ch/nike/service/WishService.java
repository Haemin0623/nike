package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Wish;

public interface WishService {
	List<Wish> wishselect(String email);
}
