package com.itwill.chobomungo.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itwill.chobomungo.common.DataSource;

public class ProductDao {
	
	private DataSource datasource;
	public ProductDao() throws Exception {
		datasource=new DataSource();
	}
	
//1. insert
	
	public int insert(Product newProduct) throws Exception {
		Connection con=datasource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_INSERT);
		pstmt.setInt(1, newProduct.getP_no());
		pstmt.setString(2, newProduct.getP_title());
		pstmt.setInt(3, newProduct.getP_price());
		pstmt.setString(4, newProduct.getP_image());
		pstmt.setString(5, newProduct.getP_desc());
		pstmt.setInt(6, newProduct.getP_click_count());
		int insertRowCount=pstmt.executeUpdate();
		
		return insertRowCount;
	}
	
	
//2. update	
	public int update(Product updateProduct) throws Exception {
		Connection con=datasource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_UPDATE);
		pstmt.setInt(1, updateProduct.getP_no());
		pstmt.setString(2, updateProduct.getP_title());
		pstmt.setInt(3, updateProduct.getP_price());
		pstmt.setString(4, updateProduct.getP_image());
		pstmt.setString(5, updateProduct.getP_desc());
		pstmt.setInt(6, updateProduct.getP_click_count());
		int updateRowCount=pstmt.executeUpdate();
		
		return updateRowCount;
	}
	

	
//3. delete	
	public int delete(int p_no) throws Exception {
		Connection con=datasource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_DELETE);
		pstmt.setInt(1,p_no);
		int deleteRowCount=pstmt.executeUpdate();
		return deleteRowCount;
	}
	
	
//4. findByPrimaryKey
	public Product findByPrimaryKey(int p_no) throws Exception {
		Connection con=datasource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_FIND_BY_KEY);
		pstmt.setInt(2, p_no);
		ResultSet rs=pstmt.executeQuery();
		
		Product findProduct=null;
		
		if(rs.next()) {
			findProduct=new Product(
					rs.getInt("p_no"),
					rs.getString("p_title"),
					rs.getInt("p_price"),
					rs.getString("p_image"),
					rs.getString("p_image"),
					rs.getInt("p_click_count"));
		}
		return findProduct;
	}

	
//5. findAll	
	public ArrayList<Product> findAll() throws Exception {
		Connection con=datasource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.PRODUCT_FIND_ALL);
		ResultSet rs=pstmt.executeQuery();
		
		ArrayList<Product> productList= new ArrayList<Product>();
		while(rs.next()) {
			productList.add(new Product(
					rs.getInt("p_no"),
					rs.getString("p_title"),
					rs.getInt("p_price"),
					rs.getString("p_image"),
					rs.getString("p_image"),
					rs.getInt("p_click_count")));
		}
		
		return productList;
		
		
		
		
		
		
		
		
	}
}
