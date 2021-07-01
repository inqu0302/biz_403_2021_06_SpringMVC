package com.callor.book.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverAbstractService;
import com.callor.book.service.impl.books.NaverBookServiceImplV2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service(NaverQualifier.NAVER_MAIN_SERVICE_V1)
public class NaverMainService {
	
	@Qualifier(NaverQualifier.NAVER_BOOK_SERVICE_V2)
	protected final NaverAbstractService<BookDTO> nBookService;
	@Qualifier(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
	protected final NaverAbstractService<MovieDTO> nMovieService;
	
	public void naverGetData(String cat, String search, Model model) throws MalformedURLException, IOException, ParseException {
		
		if(search != null && !search.equals("")) {
			
			if(cat.equalsIgnoreCase("BOOK")) {
				// 도서 검색 서비스
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.jsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				
				model.addAttribute("BOOKS", books);
				
			} else if (cat.equalsIgnoreCase("NEWS")) {
				// 뉴스 검색 서비스
			} else if (cat.equalsIgnoreCase("MOVIE")) {
				// 영화 검색 서비스
				String queryURL = nMovieService.queryURL(search);
				String jSonString = nMovieService.jsonString(queryURL);
				List<MovieDTO> movie = nMovieService.getNaverList(jSonString);
				
				model.addAttribute("MOVIE", movie);
			}
		}
	}
	
}
