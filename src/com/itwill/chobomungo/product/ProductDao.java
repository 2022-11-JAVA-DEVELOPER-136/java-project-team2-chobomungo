package com.itwill.chobomungo.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.chobomungo.common.DataSource;


public class ProductDao {

	//data 객체생성
	private DataSource dataSource;


	public ProductDao() throws Exception{

		dataSource = new DataSource();
	}	

	//insert 
	public int insert (Product product) throws Exception {

	
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_INSERT);

			pstmt.setString(1,product.getP_title());
			pstmt.setInt(2, product.getP_price());
			pstmt.setString(3, product.getP_image());
			pstmt.setString(4, product.getP_desc());
			int rowCount = pstmt.executeUpdate();
			pstmt.close();
			dataSource.close(con);
			

		return rowCount;
	
		}


	public int update (Product product) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_UPDATE);

		pstmt.setString(1,product.getP_title());
		pstmt.setInt(2, product.getP_price());
		pstmt.setString(3, product.getP_image());
		pstmt.setString(4, product.getP_desc());
		pstmt.setInt(5, product.getP_no());

		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}


	public int delete (int p_no) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_DELETE);
		pstmt.setInt(1,p_no);
		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		dataSource.close(con);
		return rowCount;

	}


	public Product findByNo(int p_no) throws Exception {
		Product newProduct = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_BY_NUMBER);
		pstmt.setInt(1, p_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int p_no1 = rs.getInt("p_no");
			String p_title = rs.getString("p_title");
			int p_price = rs.getInt("p_price");
			String p_image = rs.getString("p_image");
			String p_desc = rs.getString("p_desc");

			newProduct = new Product(p_no1,p_title,p_price,p_image,p_desc);
		}

		pstmt.close();
		dataSource.close(con);

		return newProduct;

	}

	/*
			   이름            널?       유형            
			------------- -------- ------------- 
			P_NO          NOT NULL NUMBER(20)    
			P_TITLE                VARCHAR2(50)  
			P_PRICE                NUMBER(10)    
			P_IMAGE                VARCHAR2(50)  
			P_DESC                 VARCHAR2(800) 
	 */

	public Product findByName(String p_title) throws Exception {
		Product findNameProduct = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_BY_NAME);
		pstmt.setString(1, p_title);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int p_no = rs.getInt("p_no");
			String p_title1 = rs.getString("p_title");
			int p_price = rs.getInt("p_price");
			String p_image = rs.getString("p_image");
			String p_desc = rs.getString("p_desc");

			findNameProduct = new Product(p_no,p_title1,p_price,p_image,p_desc);
		}

		pstmt.close();
		dataSource.close(con);

		return findNameProduct;


	}


	public List <Product> findByNameList (String p_title) throws Exception {

		List<Product> findBookNameList = new ArrayList<>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_BY_NAME);
		pstmt.setString(1, p_title);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {

			do {
				Product product = new Product (
						rs.getInt("p_no"),
						rs.getString("p_title"),
						rs.getInt("p_price"),
						rs.getString("p_image"),
						rs.getString("p_desc"));

				findBookNameList.add(product);

			} 	while(rs.next());

		}
		return findBookNameList;


	}

	public List <Product> productList() throws Exception {

		List <Product> productList = new ArrayList<>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_BY_ALL);
		ResultSet rs = pstmt.executeQuery();

		if(rs.next()) {
			Product product 
			= new Product (rs.getInt("p_no"), 
					rs.getString("p_title"), 
					rs.getInt("p_price"), 
					rs.getString("p_image"),
					rs.getString("p_desc"));

			productList.add(product);
		}
		return productList;
	}




}
