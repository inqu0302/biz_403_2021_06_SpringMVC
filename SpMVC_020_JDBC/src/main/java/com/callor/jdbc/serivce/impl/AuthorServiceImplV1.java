package com.callor.jdbc.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.pesistance.AuthorDao;
import com.callor.jdbc.serivce.AuthorService;

@Service("authorServiceV1")
public class AuthorServiceImplV1 implements AuthorService {

	@Autowired
	protected AuthorDao auDao;
	
	@Override
	public List<AuthorVO> selectAll() {
		
		return auDao.selectAll();
	}

	@Override
	public AuthorVO findByAcode(String au_code) {

		return auDao.findByID(au_code.trim());
	}

	@Override
	public List<AuthorVO> findByAname(String au_name) {

		return auDao.findByAName(au_name.trim());
	}

	@Override
	public List<AuthorVO> findByAtel(String au_tel) {

		return auDao.findByTel(au_tel.trim());
	}

	@Override
	public List<AuthorVO> findByNameAndTel(String au_text) {

		List<AuthorVO> nameList = auDao.findByAName(au_text);
		List<AuthorVO> telList = auDao.findByTel(au_text);
		
		// nameList에 telList를 통째로 합치기
		// 두 list의 Generic type 이 같을 경우 가능
		nameList.addAll(telList);
		
		return nameList;
	}

}
