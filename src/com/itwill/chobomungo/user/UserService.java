package com.itwill.chobomungo.user;

import java.io.IOException;
import java.util.Arrays;

public class UserService {
	private static final String LOWER_LETTER = ".*[a-z].*";
	private static final String UPPER_LETTER = ".*[A-Z].*";
	private static final String SPECIAL_CHARACTERS = ".*[!,~,@,#,$,*,^].*";

	private UserDao userDao;

	public UserService() throws Exception {
		this.userDao = new UserDao();
	}

	// 회원가입
	public int create(User user) throws Exception {
		if (userDao.countByUserId(user.getUserId()) >= 1) {
			return -1;
		} else if (user.getUserPw() == null || user.getUserPw().length() < 2 || user.getUserPw().length() > 16) {
			return -2;
		} else if (userDao.countByUserEmail(user.getUserEmail()) >= 1) {
			return -3;
		} else {
			int rowCount = userDao.insert(user);
			return rowCount;
		}
	}

	public int login(String id, String pw) throws Exception {
		int loginResult = -999;
		User findUser = userDao.findByPrimaryKey(id);
		if (findUser == null) {
			loginResult = 1;
		} else {
			if (pw.equals(findUser.getUserPw())) {
				loginResult = 0;
			} else {
				loginResult = 2;
			}
		}
		return loginResult;
	}

	/*
	 * 로그인한 회원의 정보보기
	 */
	public User findUser(String userId) throws Exception {
		return userDao.findByPrimaryKey(userId);
	}

	/*
	 * 회원수정
	 */
	public int update(User user) throws Exception {
		if (userDao.countByUserId(user.getUserId()) < 1) {
			return -1;
		} else if (user.getUserPw() == null || user.getUserPw().length() < 2 || user.getUserPw().length() > 16) {
			return -2;
		} else {
			int rowCount = userDao.update(user);
			return rowCount;
		}

	}

	/*
	 * 회원탈퇴
	 */
	public int remove(String userId, String userPw) throws Exception {
		return userDao.delete(userId, userPw);
	}

	// 아이디 찾기
	public String findId(String userName, String userPhone) throws Exception {
		return userDao.findByUserId(userName, userPhone);

	}

	// 비밀번호 찾기
	public String findPw(String userId, String userName) throws Exception {
		return userDao.findByUserPw(userId, userName);
	}

	// 이메일 중복체크
	public boolean emailDuplicateCheck(User user) throws Exception {
		boolean duplicateCheck = false;
		if (userDao.countByUserEmail(user.getUserEmail()) >= 1) {
			duplicateCheck = true;
			return duplicateCheck;
		}
		return duplicateCheck;

	}

	// 아이디 중복확인
	public boolean idCheck(String userId) throws Exception {
		boolean check = false;
		if (userDao.countByUserId(userId) >= 1) {
			check = true;
		}
		return check;
	}

}
