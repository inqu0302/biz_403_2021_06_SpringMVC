package com.callor.book.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.callor.book.model.BookDTO;
import com.callor.book.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/book")
public class BookController {
	
	protected final BookService bookService;
	
	@RequestMapping(value="/insert/{isbn}", method=RequestMethod.GET)
	public String insert(@PathVariable("isbn")String isbn, Model model) throws IOException, ParseException {
		
		log.debug("ISBN : {}",isbn);
		
		int ret = bookService.insert(isbn);
		
		return "redirect:/naver/BOOK";
	}
	
	/*
	 * 통상적인 Spring Framework의 method에서는 view 파일의 이름을
	 * String 형으로 return하고 view에서 랜더링 할 데이터는 Model객체에
	 * Attribute로 담아서 보내는 방식이다
	 * 
	 * ModelAndView 객체를 별도로 생성하여 view는 setViewName() method이용하여 
	 * setting하고 랜더링 할 데이터는 addObject() method 이용하여 추가하고 
	 * ModelAndView 객체를 return 하는 방식도 사용한다.
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		
		List<BookDTO> bookList = bookService.selectAll();
		
		log.debug("BOOK SELECT ALL {}",bookList);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		mv.addObject("MY_BOOKS",bookList);
		
		return mv;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String isbn) {
		
		// isbn을 받아서 도서정보를 findById() method를 통해 자세히 보이기 화면 구현
		
		return "home";
	}

}
