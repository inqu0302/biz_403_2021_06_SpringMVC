package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.pesistance.AuthorDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("authorV1")
public class AuthorDaoImplV1 implements AuthorDao {

	/*
	 * 일반적인 Spring Framework에서 다른 bean을 연결하기
	 * @Autowired 에서는 이미 bean으로 생성되어 Spring Container에 보관중인 객체를 
	 * 여기에 주입해 달라는 Annotation
	 * 
	 * @Inject 
	 * Java에서 기본적으로 제공하는 DI(Dependency Inject) 를 수행하는 Annotation
	 * 일부에서 @Inject를 사용하지만 SpringFramework 를 사용할때는 굳이 사용하지 않는게 좋다
	 * 버젼이 오래되어 오류발생가능성 높음
	 */
	@Autowired
	protected JdbcTemplate JdbcTemplate;
	
	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_author ";
		
		List<AuthorVO> author = JdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		log.debug("SELECT ALL AUTHOR {}", author.toString());
		
		return author;
	}

	@Override
	public AuthorVO findByID(String au_code) {
		
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_code = ? ";
		
		AuthorVO author = (AuthorVO)JdbcTemplate.query(sql, new Object[] {au_code}, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		log.debug("SELECT ALL AUTHOR {}", author.toString());
		
		return author;
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
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String name) {

		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_name LIKE CONCAT ('%', ?, '%') ";
		
		List<AuthorVO> author = JdbcTemplate.query(sql, new Object[] {name}, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		log.debug("SELECT ALL AUTHOR {}", author.toString());
		
		return author;
	}
	
	@Override
	public List<AuthorVO> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}



	/*
	 * 전화번호로 조회를 하면 1개의 데이터만 조회가 될것이다
	 * 하지만 DB 조회에서 PK 를 기준으로 조회하는 경우를 제외하고
	 * 모두 List type으로 데이터가 추출된다고 가정하고 진행한다.
	 */
	@Override
	public List<AuthorVO> findByTel(String tel) {
		
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_tel = ? ";
		
		List<AuthorVO> author = JdbcTemplate.query(sql, new Object[] {tel}, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		log.debug("SELECT ALL AUTHOR {}", author.toString());
		
		return author;
	}

}
