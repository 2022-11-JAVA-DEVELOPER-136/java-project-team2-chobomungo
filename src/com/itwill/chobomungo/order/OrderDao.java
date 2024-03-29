package com.itwill.chobomungo.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.chobomungo.cart.CartSQL;
import com.itwill.chobomungo.common.DataSource;
import com.itwill.chobomungo.product.Product;
import com.itwill.chobomungo.user.User;

public class OrderDao {
	private DataSource dataSource;

	public OrderDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Orders orders) throws Exception {
		//"insert into orders(o_no,o_desc,o_price,o_date,user_id) values(orders_o_no_SEQ_nextval,?,?,sysdate,?)"

		Connection con =null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1,orders.getO_desc());
			pstmt1.setInt(2,orders.getO_price());
			pstmt1.setString(3,orders.getUserId());
			pstmt1.executeUpdate();
			
			// "insert into order_item(oi.no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ_nextval,?,orders_o_no_SEQ_nextval,?)"
			pstmt2 = con.prepareStatement(OrderSQL.ORDERITEM_INSERT);
			for(OrderItem orderItem : orders.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null){
				pstmt1.close();
				pstmt2.close();
				dataSource.close(con);
			}
		}
		return 0;
	}
	//user_id 주문 전체 삭제
	public int deleteByUserId(String userId) throws Exception {
		Connection con =null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_USERID);
			pstmt.setString(1, userId);
			rowCount = pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null){
				pstmt.close();
				dataSource.close(con);
			}
		}
		return rowCount;
	}
	//cart_no로 주문 1개 삭제
	public int deleteByOrderNo(String userId, int o_no) throws Exception {
		Connection con =null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_ORDER_NO);
			pstmt.setString(1, userId);
			pstmt.setInt(2, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();			
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			if(con!=null){
				pstmt.close();
				dataSource.close(con);
			}
		}
		return rowCount;
	}
	//User_ID의 주문리스트
	public List<Orders> findByUserID(String userId) throws Exception {
		List<Orders> orderList = new ArrayList<Orders>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_USERID);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(new Orders(rs.getInt("o_no"),
				rs.getString("o_desc"),
				rs.getInt("o_price"),
				rs.getDate("o_date"),
				rs.getString("user_id")));
			} 
			
		} finally {
			if(con!=null){
				con.close();
			}
		}
		return orderList;
	}
	//주문1개 상세리스트
	public Orders findByOrderNo(String userId, int o_no) throws Exception {
		Orders order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_PRODUCT_USERID);
			pstmt.setString(1, userId);
			pstmt.setInt(2, o_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = new Orders(rs.getInt("o_no"),
								   rs.getString("o_desc"),
								   rs.getInt("o_price"),
								   rs.getDate("o_date"),
								   rs.getString("user_id"));
				
				do {
					order.getOrderItemList().
						add(new OrderItem(rs.getInt("oi_no"),
									rs.getInt("oi_qty"),
									rs.getInt("o_no"),
									new Product(rs.getInt("p_no"),
											rs.getString("p_title"),
											rs.getInt("p_price"),
											rs.getString("p_image"),
											rs.getString("p_desc")))
							);
				} while (rs.next());
			}
		}finally {
			if(con!=null){
				
				con.close();
			}
		}
		return order;
	}
	

}
