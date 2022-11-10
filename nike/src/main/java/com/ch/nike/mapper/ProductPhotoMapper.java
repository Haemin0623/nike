package com.ch.nike.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.nike.dto.ProductPhoto;

@Mapper
public interface ProductPhotoMapper {

	List<ProductPhoto> photoList(int productNo);

}
