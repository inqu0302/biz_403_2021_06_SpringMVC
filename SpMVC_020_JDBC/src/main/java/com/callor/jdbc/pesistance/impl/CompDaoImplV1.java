package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;

/*
 * @COMPONENT
 * 모든 Component를 대표하는 Annotation
 * 컴파일 과정에서 다소 비용이 많이 소요된다
 * 
 * @Controller, @Service, @Repository 이러한 Annotation을 사용한다
 * Spring Container 에게 이 표식이 부착된 클래스를 bean으로 생성하여
 * 보관해 달라는 지시어
 * 
 * CompVO c = new CompVO()
 * Object o = new CompVO()
 * 
 * CompServiceImplV1 cs = new compserviceImplV1()
 * CompService sc1 = new CompServiceImplV1();
 */
@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao {
	
	protected final JdbcTemplate JdbcTemplate;
	
	public CompDaoImplV1(JdbcTemplate JdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.JdbcTemplate = JdbcTemplate;
	}
	
	@Override
	public List<CompVO> selecAll() {
		// TODO 출판사 전체조회
		
		String sql = " SELECT * FROM tbl_company ";
		
		List<CompVO> comp = JdbcTemplate.query(sql, new BeanPropertyRowMapper<CompVO>(CompVO.class));
		
		log.debug("SELCT ALL COMP {}", comp.toString());
		
		return comp;
	}

	@Override
	public CompVO findByID(String pk) {
		// TODO Auto-generated method stub
		String sql= " SELECT * FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		Object[] params = new Object[] {pk};
		
		CompVO vo = (CompVO)JdbcTemplate.query(sql, new BeanPropertyRowMapper<CompVO>(CompVO.class));
		return vo;
	}

	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_company ";
		sql += " (cp_code, cp_title, cp_ceo, cp_addr, cp_tel) ";
		sql += " VALUES( ?,?,?,?,? ) ";
		
		Object[] params = new Object[] {
				vo.getCp_code(),
				vo.getCp_title(),
				vo.getCp_ceo(),
				vo.getCp_addr(),
				vo.getCp_tel()
		};
		
		return JdbcTemplate.update(sql,params);
	}

	@Override
	public int update(CompVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* jdbcTemplate를 사용하여 QUERY를 실행할때 각 method에서 매개변수를 받아
	 * QUERY에 전달하는데 이때 매개변수는 primitive로 받으면 값을 변환시키는 어려움이 있다.
	 * 그래서 매개변수는 wrapper class type으로 설정하는것이 좋다
	 * 
	 * 숫자형일 경우 int, long 대신 Integer, Long형으로 선언
	 * 
	 * vo에 담겨서 전달된 값은 Object[]배열로 변환후 
	 * jdbcTemplate에 전달해 주어야 한다.
	 *  
	 * 하지만 1 ~ 2개 정도의 값을 전달할때 Object[]배열로 변환 후 전달을 하면 
	 * Object 객체 저장소가 생성되고 메모리를 사용한다
	 * 
	 * 이때 전달되는 변수가 wrapper class type 이면 Object[] 배열로 만들지 않고 바로 주입할수 있다.
	 */
	@Override
	public int delete(String cpcode) {
		// TODO 출판사정보 삭제
		String sql = " DELETE FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		// cpcode가 String wrapper class type 이므로 변환하지 않고 바로 전달이 가능하다
//		Object[] params = new Object[] {cpcode};
		
		return JdbcTemplate.update(sql,cpcode);
		
		
	}

	@Override
	public List<CompVO> findByCName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CompVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * tbl_company table 에서 cp_code(출판사 코드) 중 가장 큰 값 추출하기
	 */
	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		String sql = " SELECT MAX(cp_code) FROM tbl_company ";
		
		String cpCode = (String)JdbcTemplate.queryForObject(sql, String.class);
		
		return cpCode;
	}

}
