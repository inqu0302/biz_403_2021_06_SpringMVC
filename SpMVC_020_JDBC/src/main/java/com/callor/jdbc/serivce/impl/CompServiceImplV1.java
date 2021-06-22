package com.callor.jdbc.serivce.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.serivce.CompService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("compServiceV1")
public class CompServiceImplV1 implements CompService {

	protected final CompDao compDao;
	
	public CompServiceImplV1(CompDao compDao) {
		// TODO Auto-generated constructor stub
		this.compDao = compDao;
		
	}
	
	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String cpCode = compDao.findByMaxCode();
		log.debug("cpCode : " + cpCode);
		
		if(cpCode == null || cpCode.equals("")) {
			
			// C00001
			cpCode = String.format("C%04d",1);
			
		} else {
			// 영문 접두사 C를 자르고 숫자만 추출
			String _code = cpCode.substring(1);
			Integer intCode = Integer.valueOf(_code) + 1;
			
			cpCode = String.format("C%04d", intCode);
			
		}
		
		vo.setCp_code(cpCode);
		compDao.insert(vo);
		
		return 0;
	}

	@Override
	public List<CompVO> findByCname(String cp_name) {

		// 전달받은 출판사 이름에서 앞뒤 빈칸을 제거하고
		// Dao 에게 넘겨 출판사 리스트를 받아 리턴하기
		return compDao.findByCName(cp_name.trim());
	}

	@Override
	public List<CompVO> selectAll() {

		return compDao.selectAll();
	}

	@Override
	public CompVO findByCpcode(String cp_code) {

		return compDao.findByID(cp_code.trim());
	}

	@Override
	public List<CompVO> findByTitleAndCeoAndTel(String searchText) {
		// TODO 변수를 입력받아 title,ceo,tel 중 하나로 검색
		
		List<CompVO> mainList = compDao.findByCName(searchText);
		List<CompVO> ceoList = compDao.findByCeo(searchText);
		List<CompVO> telList = compDao.findByTel(searchText);
		
		mainList.addAll(ceoList);
		mainList.addAll(telList);
		
		return mainList;
	}
	
	

}
