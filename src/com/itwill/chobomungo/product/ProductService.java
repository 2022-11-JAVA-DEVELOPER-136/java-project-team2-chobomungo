package com.itwill.chobomungo.product;

import java.util.List;

public class ProductService {
	private ProductDao productDao;
	public ProductService() throws Exception {
		productDao=new ProductDao();
	}
/*
 * 상품 추가, 상품 삭제, 전체 상품 보기, 한개의 상품 상세보기,
 */
	
	
	
//1. 전체 상품 보기
	public List<Product> productList() throws Exception{
		return productDao.findAll();
	}
	
//2. 한개의 상품 상세 보기
	public Product productDetail(int p_no) throws Exception {
		return productDao.findByPrimaryKey(p_no);
	}
	
//3. 상품 1개 추가: 중복 시 추가 안되게!
	
//	public int create(Product product) {
//		if(productDao.) {
			


}
