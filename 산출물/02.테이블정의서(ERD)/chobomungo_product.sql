--product table CRUD sql

--insert
insert into product(p_no,p_title,p_price,p_image,p_desc,p_click_count) 
values(product_p_no_SEQ.nextval, 
'AA', 10000, 'default.jpg','추천도서', 3);

--update PK
update product set p_title='소설',p_price=20000,p_image='image.jpg',
p_desc='책정보상세보기', P_click_count=2 where p_no=1;

--delete PK
delete from product where p_no=1;


--select PK
select p_no,p_title,p_price,p_image from product where p_no=2;

--select All
select p_no,p_title,p_price,p_image,p_desc,p_click_count from product;