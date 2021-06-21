package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.pesistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("UserDaoV1")
public class UserDaoImplV1 implements UserDao{
	
	
	
	// 생성자에서 주입받는 객체
	// 생성자에서 주입받아 초기화 하는 객체는 @component로 선언된 클래스만 가능
	protected final JdbcTemplate JdbcTemplate;
	
	public UserDaoImplV1(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findByID(String username) {
		
		String sql = " SELECT * FORM tbl_member ";
		sql += " WHERE mb_username = ? ";
		
		Object[] params = new Object[] {username};
		
		UserVO vo = (UserVO)JdbcTemplate.query(sql, params, new BeanPropertyRowMapper<UserVO>(UserVO.class));
		
		return vo;
	}

	@Override
	public int insert(UserVO vo) {
		String sql = " INSERT INTO tbl_member ( username, password ) ";
		sql += " VALUES( ?, ?) ";
		
		// JdbcTemplate로 query 를 전송할때 전달할 값이 몇개 안될때는
		// Object[] 배열로 만들지 않아도 된다.
		
		return JdbcTemplate.update(sql,
				vo.getUsername(), vo.getPassword());
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
