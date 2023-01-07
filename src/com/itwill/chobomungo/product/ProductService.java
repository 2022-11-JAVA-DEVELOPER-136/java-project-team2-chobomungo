package com.itwill.chobomungo.product;

import java.util.List;

public class ProductService {
	private static ProductDao productDao;
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
	
	public static boolean addMember(Product newProduct) throws Exception {
		boolean isSuccess=false;
		/*
		 * 상품 존재 여부 확인하고
		 * 	- 존재하면 메세지
		 *  - 존재안하면 상품 추가하기
		 */
		if(productDao.findByPrimaryKey(newProduct.getP_no())==null) {
			int rowCount=productDao.insert(newProduct);
			isSuccess=true;
		}else {
			isSuccess=false;
		}
		return isSuccess;
	}
			
	//3-1. 중복체크 안하고 그냥 상품 추가
	
	public int productWrite(Product product) throws Exception {
		
		return productDao.insert(product);
	} 
	
	//4. 상품 수정
	public int productUpdate(Product product) throws Exception{
		return productDao.update(product);
		
	//5. 상품 삭제
//	public int productDelete(int p_no)throws Exception {
//			return productDao.delete(p_no);
//		}
//		
	}


	//중복체크 시 필요한 메소드
	public static boolean addProduct(Product product) {
		return false;
	}





}
