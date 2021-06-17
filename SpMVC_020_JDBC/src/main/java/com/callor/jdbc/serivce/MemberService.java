package com.callor.jdbc.serivce;

import com.callor.jdbc.model.UserVO;

public interface MemberService {
	
	/*
	 * login 기능은 username(ID), password를 매개변수로 받아서
	 * 회원정보를 검색한 후 유효한 회원이면 회원정보를 return 
	 * 그렇지 않으면 null을 return 하는 구조로 설계
	 */
	public UserVO login(String username, String password);
	
	public int join(UserVO userVO);
	
	public UserVO viewInfo(String username);
	public int updateInfo(UserVO userVO);
	
	public int exprie(String username);
}
