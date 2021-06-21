package com.callor.jdbc.serivce;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

public interface AuthorService {

	public List<AuthorVO> selectAll();
	
	public AuthorVO findByAcode(String au_code);
	
	public List<AuthorVO> findByAname(String au_name);
	
	public List<AuthorVO> findByAtel(String au_tel);
}
