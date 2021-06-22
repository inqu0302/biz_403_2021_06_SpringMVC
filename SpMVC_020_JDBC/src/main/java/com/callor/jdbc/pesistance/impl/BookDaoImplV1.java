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
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT ";
		sql += " bk_isbn, "
				+ " bk_title, "
				+ " C.cp_title as bk_code, "
				+ " A.au_name as bk_acode, "
				+ " bk_date, "
				+ " bk_price, "
				+ " bk_pages ";
			sql += " FROM tbl_books B ";
			sql += " LEFT JOIN tbl_author A ";
			sql += " ON B.bk_acode = A.au_code ";
			sql += " LEFT JOIN tbl_comp C ";
			sql += " ON B.bk_ccode = C.cp_code ";
		/*
		 * jdbcTemplate.query(sql,return type)
		 * sql문을 실행한 후 return type형태로 데이터를 변환하여 return
		 */
		List<BookVO> books = JdbcTemplate.query(sql, new BeanPropertyRowMapper<BookVO>(BookVO.class));
		
		log.debug("SELECT All books {}", books.toString());
		
		return books;
	}

	@Override
	public BookVO findByID(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		// TODO 정보 입력하기
		
		String sql = " INSERT INTO tbl_books ";
		sql += " (bk_isbn, "
				+ " bk_title, "
				+ " bk_ccode, "
				+ " bk_acode, "
				+ " bk_date, "
				+ " bk_price, "
				+ " bk_pages ) ";
		sql += " VALUES( ?, ?, ?, ?, ?, ?, ? ) ";
		
		Object[] params = new Object[] {
				vo.getBk_ISBN(),
				vo.getBk_title(),
				vo.getBk_ccode(),
				vo.getBk_acode(),
				vo.getBk_date(),
				vo.getBk_price(),
				vo.getBk_pages()};
		
		// insert, update, delete 모두 update() method 사용
		
		return JdbcTemplate.update(sql, params);
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
