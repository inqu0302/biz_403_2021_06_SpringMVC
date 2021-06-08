package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.pesistance.AuthorDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("authorV1")
public class AuthorDaoImplV1 implements AuthorDao {

	protected final JdbcTemplate JdbcTemplate;
	
	public AuthorDaoImplV1(JdbcTemplate JdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.JdbcTemplate = JdbcTemplate;
	}
	
	@Override
	public List<AuthorVO> selecAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_author ";
		
		List<AuthorVO> author = JdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		log.debug("SELCT ALL AUTHOR {}", author.toString());
		
		return null;
	}

	@Override
	public AuthorVO findByID(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletd(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AuthorVO> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<AuthorVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

}
