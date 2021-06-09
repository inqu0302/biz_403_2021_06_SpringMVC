package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("bookDaoV1") // 클래스 이름 적기
public class BookDaoImplV1 implements BookDao{
	
	// Console로 log를 찍기 위하여 log 객체 생성
	// 롬복의 slf4j 를 이용하여 대신생성
	// private static Logger log = LoggerFactory.getLogger("SERVICE");
	
	// jdbc-context.xml에 선언된 jdbcTemplate bean 사용하기
	protected final JdbcTemplate JdbcTemplate;
	
	public BookDaoImplV1(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}
	
	@Override
	public List<BookVO> selecAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_books ";
		/*
		 * jdbcTemplate.query(sql,return type)
		 * sql문을 실행한 후 return type형태로 데이터를 변환하여 return
		 */
		List<BookVO> books = JdbcTemplate.query(sql, new BeanPropertyRowMapper<BookVO>(BookVO.class));
		
		log.debug("SELECT All books {}", books.toString());
		
		return null;
	}

	@Override
	public BookVO findByID(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> findBYName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
