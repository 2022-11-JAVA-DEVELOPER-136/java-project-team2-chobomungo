/**********************member insert************************/
insert into userinfo(user_id,user_pw,user_name,user_phone,user_address,user_email) values('book1','1111','정약용','010-1111-1111','서울시 중구','book1@korea.com');
insert into userinfo(user_id,user_pw,user_name,user_phone,user_address,user_email) values('book2','2222','이순신','010-2222-2222','서울시 관악구','book2@korea.com');
insert into userinfo(user_id,user_pw,user_name,user_phone,user_address,user_email) values('book3','3333','이방원','010-3333-3333','서울시 종로구','book3@korea.com');

commit;
/**********************product insert************************/

insert into product values(product_p_no_SEQ.nextval, '만일 내가 인생을 다시 산다면', 10000, '/product_Image/국내도서1.png',
'“하나의 문이 닫히면 또 하나의 문이 열린다. 그러니 
더 이상 고민하지 말고 그냥 재미있게 살아라!” 저자
가30년간 정신분석 전문의로 일하며 깨달은 인생의 
비밀과 22년간 파킨슨병을 앓으면서도 유쾌하게 살 
수 있는이유를 전한다. 또한 ‘완벽한 때는 결코 오지 
않는법이다’, ‘때론 버티는 것이 답이다’, ‘제발 모든 
것을 상처라고 말하지 말 것’, ‘가까운 사람일수록 해
서는 안 될 것들이 있다’ 등 환자들에게 미처 하지 못
했던 그러나 꼭 해 주고 싶은 이야기들을 담고 있다.');
insert into product values(product_p_no_SEQ.nextval, '불편한 편의점', 15000, '/product_Image/국내도서2.png',
'원 플러스 원의 기쁨, 삼각김밥 모양의 슬픔, 만 원에
네 번의 폭소가 터지는 곳! 힘겨운 시대를 살아가는 우
리들에게 다가온 조금 특별한 편의점 이야기! 서울역에
서 노숙인 생활을 하던 독고라는 남자가 어느 날 70대 
여성의 지갑을 주워준 인연으로 그녀가 운영하는 편의
점에서 야간 알바를 하면서 이야기가 시작된다.');
insert into product values(product_p_no_SEQ.nextval, '하얼빈', 18000, '/product_Image/국내도서3.png',
'『하얼빈』은 안중근에게 드리워져 있던 영웅의 그늘
을걷어내고 그의 가장 뜨겁고 혼란스러웠을 시간을 현
재에되살려놓는다. 소설 안에서 이토 히로부미로 상징
되는 제국주의의 물결과 안중근으로 상징되는 청년기
의 순수한 열정이 부딪치고, 살인이라는 중죄에 임하
는 한 인간의 대의와 윤리가 부딪치며, 안중근이 천주
교인으로서 지닌 신앙심과 속세의 인간으로서 지닌 증
오심이 부딪친다. 이토록 다양한 층위에서 벌어지는 
복합적인 갈등을 날렵하게 다뤄내며 안중근이라는 인
물을 바라보는 시야의 차원을 높이는 이 작품은 김훈
의 새로운 대표작으로 소개되기에 모자람이 없다.');
insert into product values(product_p_no_SEQ.nextval, '미드나잇 라이브러리', 15000, '/product_Image/해외도서1.png',
'죽기로 결심한 주인공 ‘노라 시드’가 삶과 죽음 사이
에 존재하는 미스터리한 도서관 ‘미드나잇 라이브러리’
에서 눈을 뜨며 인생의 두 번째 기회를 얻는 이 소설
은,노라의 가장 완벽한 삶을 찾는 모험을 따라가며 
‘살아 있음’과 ‘살아가는 것’에 대한 깊은 통찰을 보
여준다. 타인의 삶에 대한 공감, 자신의 삶에 대한 
긍정, 살아 있는 것 자체가 살아야 할 이유라는 깊은 
통찰력까지 매트 헤이그 작가가 보내는 공감과 위로의 
메시지는 세대와성별을 아우르며 전 세계 독자들의 
마음을 사로잡았다.');
insert into product values(product_p_no_SEQ.nextval, '테라피스트', 20000, '/product_Image/해외도서2.png',
'극도의 불안이 흐르는 스토리와 통쾌한 반전! 끝을 보
기 전까지 책을 절대 내려놓을 수 없다! 평범한 여성을
주인공으로 삼고 그들이 처한 특수한 상황과 교묘한 심
리를 집요하게 파고들어 독자들을 옴짝달싹 못 하게 만
드는 패리스 작가만의 서늘한 서스펜스가 《테라피스트
》에서는 한층 더 강해졌다.');
insert into product values(product_p_no_SEQ.nextval, '노르웨이의 숲', 20000, '/product_Image/해외도서3.png',
'독일 함부르크 공항에 막 착륙한 비행기 안에서 울린 
비틀스의 《노르웨이의 숲》을 듣고 와타나베는 자신
에게 간절한 부탁을 남긴 여자와 그 부탁을 떠올린다. 
고등학교 시절 친한 친구 기즈키, 그의 여자 친구 나
오코와 언제나 함께였던 와타나베. 그러나 기즈키의 
갑작스러운 자살로 행복한 시간은 끝나 버리고 만다.
도쿄의사립대학에 진학해 고향을 떠나온 와나타베는 
나오코와한동안 연락을 끊고 지내던 어느 날, 자신이
요양원에 들어가 있다는 나오코의 편지를 받는데…….');

commit;


/**********************product update************************/
update product set p_title='안녕' ,p_price=12500, p_image='sample.jpg',p_desc='반값세일중' where p_no=3;

/**********************product delete***********************/
delete from product where p_no=7;

/**********************product select_by_no************************/
select p_no,p_title,p_price,p_image,p_desc,p_click_count from product where p_no=3;

/**********************product select_all************************/
select p_no,p_title,p_price,p_image,p_desc,p_click_count from product;




/**********************cart insert***************************/
--book1
insert into cart values(cart_cart_no_SEQ.nextval,1,'book1',1);
insert into cart(cart_no,cart_qty,user_id,p_no) values(cart_cart_no_SEQ.nextval,1,'book1',2);
--book2    
insert into cart(cart_no,cart_qty,user_id,p_no) values(cart_cart_no_SEQ.nextval,1,'book2',4);
insert into cart(cart_no,cart_qty,user_id,p_no)
    values(cart_cart_no_SEQ.nextval,2,'book2',5);
    
/*********************order insert***********************/
--book1
--1.orders insert
insert into orders(o_no,o_desc,o_date,o_price,user_id)
    values(orders_o_no_SEQ.nextval,'...',sysdate,41000,'book1');

--2.order item insert
--제품번호 3번 1권
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
--제품번호 6번 1권
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,6);
    
--book2
--1.orders insert
insert into orders(o_no,o_desc,o_date,o_price,user_id)
    values(orders_o_no_SEQ.nextval,'...',sysdate,47000,'book2');

--2.order item insert
--제품번호 7번 1권
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,7);
--제품번호 8번 1권
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,8);
    
    commit;
    

