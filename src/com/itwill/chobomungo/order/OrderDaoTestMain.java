package com.itwill.chobomungo.order;

import java.util.ArrayList;
import java.util.Date;

import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.product.ProductDao;
import com.itwill.chobomungo.user.User;

public class OrderDaoTestMain {
	public static void main(String[] args) throws Exception{
		
		OrderDao orderDao=new OrderDao();
		System.out.println(orderDao.findByUserID(new Orders(0,null,0,null,new User("book1",null,null,null,null,null))));
		System.out.println(orderDao.findByOrderNo(new Orders(1,null,0,null,new User("book1",null,null,null,null,null))));
		
		/*
		 * 1.상품에서직접주문
		 */
		
		int p_qty=1;
		int p_no=1;
		ProductDao productDao=new ProductDao();
		Product product=productDao.findByNo(p_no);
		
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		orderItemList.add(new OrderItem(0, p_qty, p_no, product));
		
		Orders newOrder=new Orders(0,product.getP_title()+"외 0종" ,  product.getP_price(), new Date(0), new User("book1",null,null,null,null,null));
		orderDao.insert(newOrder);
		
		/*
		 * 2.cart에서 주문
		 */
		
		
		
	}
}
