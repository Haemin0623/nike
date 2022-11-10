package com.ch.nike.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ch.nike.dto.ProductDetail;

@Mapper
public interface ProductDetailMapper {


	List<ProductDetail> detailList(int productNo);

}
