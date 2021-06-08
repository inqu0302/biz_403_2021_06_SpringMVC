package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

public interface AuthorDao extends GenericDao<AuthorVO, String>{
	
	public List<AuthorVO> findByAName(String name);
	
	public List<AuthorVO> findByTel(String tel);
	
	public List<AuthorVO> findByGenre(String genre);

}
