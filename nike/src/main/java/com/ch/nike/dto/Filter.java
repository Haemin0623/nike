package com.ch.nike.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("Filter")
public class Filter {
	private String[] gender;
	private String[] color;
	private Integer[] price;
	private String[] productSize;
	private String[] large;
	private String[] small;
	
	// 페이징
	private int currentPage;
	private int rowPerPage;
	private int total;
	private int totalPage;
	private int pagePerBlock = 10;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private String search;
	private String keyword;
	private int orderNo;
	
	public Filter() {
	}
	
	public Filter(int currentPage, int rowPerPage, int total) {
		
		this.currentPage = currentPage;
		this.rowPerPage = rowPerPage; 
		this.total = total;
		
		totalPage = (int)(Math.ceil((double)total/rowPerPage));
		
		startPage = currentPage - (currentPage - 1) % pagePerBlock;		
		endPage = startPage + pagePerBlock - 1;
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}
}
