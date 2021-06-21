package com.callor.jdbc.serivce.impl;

import org.springframework.stereotype.Service;

import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.serivce.RentService;

@Service("rentV1")
public class RentServiceImplV1 implements RentService{

	protected final BookDao bookDao;
	protected final CompDao compDao;
	
	public RentServiceImplV1(BookDao bookDao, CompDao compDao) {
		
		this.bookDao = bookDao;
		this.compDao = compDao;
		
	}
	
	@Override
	public void viewBookAndComp() {
		
		bookDao.selectAll();
		compDao.selectAll();
	}

}
