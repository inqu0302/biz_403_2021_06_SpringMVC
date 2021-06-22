package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.serivce.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping( value = "/books")
@RequiredArgsConstructor
@Controller
public class BookController {
	
	protected final BookService bkService;
	
	// localhost:8080/jdbc/books/ 또는 localhost:8080/jdbc/books 일때 
	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
	public String books(HttpSession hSession, Model model) {
		
		// HttpSession 에서 USERVO 정보 찾기
		Object obj = hSession.getAttribute("USERVO");
		
		UserVO userVO = (UserVO)obj;
		
//		// USERVO 정보가 없으면 
//		if(userVO == null) {
//			
//			// Login 화면으로 jump
//			model.addAttribute("MSG", "LOGIN");
//			
//			return "redirect:/member/login";
//		}
		
		List<BookVO> bookList = bkService.selectAll();
		model.addAttribute("BOOKS", bookList);
		
		log.debug("BOOKS ROOT");
		return "books/list";
	}
	
	@RequestMapping(value ="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "books/input";
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute BookVO bookVO) {
		/*
		 * form에서 건너온 데이터들이 Bookvo에 담는 동안에 bookVO의 변수들 (속성, property) 중에 숫자형 변수가 있을경우
		 * 건너온 데이터는 문자열에서 숫자형으로 형 변환을 시도하는데 아무런 값이 없을경우 다음과 같은 코드가 실행되는데
		 *  bookVO.setBk_pages(Integer.valueOf(""));
		 * NumberformatException이 발생하게 되고 즉시 client에서 400 오류를 전달한다. 
		 * 
		 * 이를 막기위해 jsp에서 default 값을 설정해 준다
		 */
		
		Integer ret = bkService.insert(bookVO);
		
		return "redirect:/books";
	}
	
}
