package com.itwill.chobomungo.product.test;

import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao=new ProductDao();
//		Product newProduct=new Product(product_p_no_SEQ.nextval, 
//"AA", 10000, "default.jpg","추천도서", 3);
//		
		System.out.println("1. insert: "+productDao.insert
				(new Product(0, "AA", 10000, "default.jpg","추천도서", 3)));
		
		System.out.println("2. update: "+productDao.insert(new Product(1, "AA", 20000, "default.jpg","추천도서", 3)));

		System.out.println("3. delete: "+productDao.delete(1));
		
		System.out.println("4. findByPrinmaryKey: "+productDao.findByPrimaryKey(2));
		
		System.out.println("5. findAll: "+productDao.findAll());
	}

}
