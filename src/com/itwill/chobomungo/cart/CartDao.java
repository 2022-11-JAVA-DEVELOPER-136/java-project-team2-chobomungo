package com.itwill.chobomungo.cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.chobomungo.common.DataSource;
import com.itwill.chobomungo.product.Product;

public class CartDao {
	
	private DataSource dataSource;
	
	public CartDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insertCart() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.INSERT_CART_SQL);
		pstmt.setInt(1, 2);
		pstmt.setString(2, "book3");
		pstmt.setInt(3,2);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
		
	}
	
	public int updateCart() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.UPDATE_CART_SQL);
		pstmt.setInt(1, 3);
		pstmt.setString(2, "book3");
		pstmt.setInt(3, 2);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
		
	}
	
	public int deleteCart() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.DELETE_CART_SQL);
		pstmt.setString(1, "book3");
		pstmt.setInt(2, 2);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public void findByP_NoCart() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.FIND_BY_P_NO_CART_SQL);
		pstmt.setString(1,"book1");
		pstmt.setInt(2, 1);
		ResultSet rs = pstmt.executeQuery();
		Cart tempCart = null;
		if(rs.next()) {
			tempCart.setCart_no(rs.getInt("cart_no"));
			tempCart.setCart_qty(rs.getInt("cart_qty"));
			tempCart.setUser_id(rs.getString("user_id"));
			tempCart.setProduct(new Product());
		}
		
	}
}
