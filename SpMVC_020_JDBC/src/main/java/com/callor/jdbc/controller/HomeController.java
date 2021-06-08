package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.serivce.RentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 보편적인 Spring에서 bean 을 사용하는 코드
	// @Autowired
	// private BookDao BookDao
	// 이 코드에서 메모리 leak(누수)현상이 보고되어 아래코드를 권장한다
//	protected final BookDao bookDao;
	protected final RentService rentService;
	
	public HomeController(RentService rentService) {
		// TODO Auto-generated constructor stub
		this.rentService = rentService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		
		rentService.viewBookAndComp();
		
		return "home";
	}
	
}
