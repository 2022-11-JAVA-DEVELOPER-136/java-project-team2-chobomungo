package com.itwill.chobomungo.order;

import java.util.ArrayList;
import java.util.Date;

import com.itwill.chobomungo.cart.CartDao;
import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductDao;
import com.itwill.chobomungo.user.User;

public class OrderService {
	OrderDao orderDao = null;
	CartDao cartDao = null;
	ProductDao productDao = null;
	ArrayList<OrderItem> orderItemList = null;
	
	// 1. 상품에서 직접주문
	public int orderByProductNo(int p_qty, int p_no,User user) throws Exception {
		productDao = new ProductDao();
		orderItemList = new ArrayList<OrderItem>();
		Product product = productDao.findByNo(p_no);
		orderItemList.add(new OrderItem(0,p_qty,p_no,product));
		Orders newOrder = new Orders(0,product.getP_title()+"외 0종", product.getP_price(), new Date(), user); 
		
		
		
		return 0;
	}
	//2. 카트에서 주문
	
	//3. 주문번호로 삭제
	public int removeByOrderNo(Orders order) throws Exception {
		return orderDao.deleteByOrderNo(order);
	}
	//4. 전체삭제
	public int removeByUserId(Orders order) throws Exception {
		return orderDao.deleteByUserId(order);
	}
	// userId 주문리스트

	// 주문1개 상세
	
}
