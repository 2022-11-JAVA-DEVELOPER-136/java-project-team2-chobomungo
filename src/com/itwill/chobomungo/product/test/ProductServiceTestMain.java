package com.itwill.chobomungo.product.test;

import javax.swing.JOptionPane;

import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductDao;
import com.itwill.chobomungo.product.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args, Object findProduct) throws Exception {
		ProductDao productDao=new ProductDao();
		ProductService productService=new ProductService();
		
		//1. 전체 상품 보기
		System.out.println("findAll >>"+productDao.findAll());
		
		//2. 상품번호 1번으로 찾기
		System.out.println("findByPrimaryKey >>"+productDao.findByPrimaryKey(1));
		
		//3. 상품 추가-중복 체크하면서..다시보기
		System.out.println("상품 추가하기");
		boolean addSuccess1 = 
				ProductService.addProduct(new Product(1, "소설3", 15000,"image.jpg", "상세페이지",5));
		if(addSuccess1) {
			System.out.println("상품 추가페이지로 이동");
		}else {
			JOptionPane.showMessageDialog(null, "중복된 상품입니다.");
		}
		boolean addSuccess2=
				ProductService.addProduct(new Product
						(2, "소설4", 20000,"image.jpg", "상세페이지",5));
		if(addSuccess2) {
			System.out.println("상품 추가페이지로 이동");
		}else {
			JOptionPane.showMessageDialog(null, "중복된 상품입니다."); 
		}
		
		//3-1. 그냥 상품 추가
		Product newProduct=new Product(1, "소설3", 15000,"image.jpg", "상세페이지",5);
		System.out.println(">> "+productService.productWrite(newProduct));
		
		//4. 상품 수정
	
//		findProduct.("333-3333");
//		System.out.println(">> "+productService.productUpdate(product));
//		System.out.println(">> "+productService.productDetail(3));
//		
//		
//		//5. 상품 삭제
//		System.out.println(">>"+productService.productDelete(2));
	}
}
