package com.callor.jdbc.serivce;

import java.util.List;

import com.callor.jdbc.model.CompVO;

public interface CompService {

	public int insert(CompVO vo);
	
	public List<CompVO> findByCname(String cp_code);
	
	public List<CompVO> selectAll();
	
	public CompVO findByCpcode(String cp_code);

	public List<CompVO> findByTitleAndCeoAndTel(String searchText);
}
