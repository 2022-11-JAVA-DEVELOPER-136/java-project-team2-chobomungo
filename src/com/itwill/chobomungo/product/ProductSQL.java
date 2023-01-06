package com.itwill.chobomungo.product;

/*
 * --insert
insert into product values(p_no,p_title,p_price,p_image,p_desc,p_click_count)
(product_p_no_SEQ.nextval, 
'소설1', 10000, 'default.jpg','추천도서', 1);

--update PK
update product set p_title='소설2',p_price=20000,p_image='image.jpg',
p_desc='책정보상세보기', P_click_count=2 where p_no=1;

--delete PK
delete from product where p_no=1;


--select PK
select p_no,p_title,p_price,p_image from product where p_no=2;

--select All
select p_no,p_title,p_price,p_image,p_desc,p_click_count from product;
 */

public class ProductSQL {

	public static final String PRODUCT_INSERT=
			"insert into product(p_no,p_title,p_price,p_image,p_desc,p_click_count)"
			+ "values(product_p_no_SEQ.nextval,?,?,?,?,?)";
	
	public static final String PRODUCT_UPDATE="update product set p_title=?,p_price=?,"
			+ "p_image=?, p_desc=?, P_click_count=? where p_no=?";
	
	public static final String PRODUCT_DELETE="delete from product where p_no=?";
	
	public static final String PRODUCT_FIND_BY_KEY="select p_no,p_title,p_price,p_image from product where p_no=?";
	
	public static final String PRODUCT_FIND_ALL="select p_no,p_title,p_price,p_image,p_desc,p_click_count from product";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
