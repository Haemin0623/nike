package com.ch.nike.service;

import java.util.List;

import com.ch.nike.dto.Product;
import com.ch.nike.dto.ProductPhoto;
import com.ch.nike.dto.Wish;

public interface WishService {

	List<Wish> wishList(String email);



}
