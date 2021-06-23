package com.callor.score.dao;

import java.util.List;

/*
 * Generic interface
 * 매개변수, return type이 정해지지 않은 인터페이스
 * 같은 기능의 metod를 갖는 인터페이스를 설계할때 복사,붙여넣기 등을 하지않고
 * 공통된 method를 구현하기위한 표준 parent형 인터페이스 
 */
public interface GenericDao<VO, Pk> {

	public List<VO> selectAll();
	public VO findById(Pk pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(Pk pk);
}
