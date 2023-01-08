package com.itwill.chobomungo.user.test;

import com.itwill.chobomungo.user.User;
import com.itwill.chobomungo.user.UserDao;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception {

		int rowCount = -999;
		UserDao userdao = new UserDao();

		System.out.println("1.insert");
		User user = new User("book22", "4444", "손동필", "010-4444-4444", "서울시 강북구", "book4@korea.com");
		rowCount = userdao.insert(user);
		System.out.println(rowCount);

		System.out.println("2.update");
		User user2 = new User("book2", "1234", "3순신", "010-2222-2222", "서울 강서구", "boo2@naver.com");
		rowCount = userdao.update(user2);
		System.out.println(rowCount);

		System.out.println("3.delete");
		rowCount = userdao.delete("book23");
		System.out.println(rowCount);

		System.out.println("3.findByPrimaryKey- ");
		User user3 = userdao.findByPrimaryKey("book1");
		System.out.println(user3);

		System.out.println("4.countByUserId");
		rowCount = userdao.countByUserId("book1");
		System.out.println(rowCount);

		System.out.println("5.findId");
		String findId = userdao.findByUserId("정약용", "010-1111-1111");
		System.out.println(findId);

		System.out.println("6.findPw");
		String findPw = userdao.findByUserPw("book1", "정약용");
		System.out.println(findPw);

	}

}
