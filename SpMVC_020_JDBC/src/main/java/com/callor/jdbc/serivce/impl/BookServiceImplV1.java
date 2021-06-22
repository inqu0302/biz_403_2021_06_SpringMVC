package com.callor.jdbc.serivce.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.serivce.BookService;

import lombok.RequiredArgsConstructor;

/*
 * 핃르변수를 private, final, protected final 로 선언하면
 * 반드시 생선자에서 해당변수를 초기화 해주어야 한다
 * 이때 매개변수로 전달받거나 직접 new 키워드를 생성하는데
 * 
 * Spring 에서는 new 키워드를 사용하지 않고 Spring Contaner로 부터 주입을 받기때문에
 * 해당 변수들을 매개변수로 갖는 생성자가 필요하다
 * 
 * 매번 생성자를 만드는 것이 귀찮은 일이고 변수를 추가, 제거, 변경할때 마다
 * 생성자를 다시 코딩해야 하는 불편함을 대신해준다
 * 
 * Lombok의 Annotaion이다 
 */
@RequiredArgsConstructor
@Service("bookServiceV1")
public class BookServiceImplV1 implements BookService{

	protected final BookDao bookDao;
	
	@Override
	public List<BookVO> selectAll() {

		return bookDao.selectAll();
	}

	@Override
	public Integer insert(BookVO bookVO) {
		//TODO 도서정보 입력하기
		
		return bookDao.insert(bookVO);
	}

}
