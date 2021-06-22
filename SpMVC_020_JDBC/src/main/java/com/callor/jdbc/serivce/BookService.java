package com.callor.jdbc.serivce;

import java.util.List;

import com.callor.jdbc.model.BookVO;

public interface BookService {

	public List<BookVO> selectAll();

	public Integer insert(BookVO bookVO);

		
	
}
