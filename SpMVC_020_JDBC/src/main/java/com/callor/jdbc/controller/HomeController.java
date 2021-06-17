package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${user.name}")
	protected String user_name;
	
	@Value("${user.email}")
	protected String user_email;
	
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
		/*
		 * HttpSession 객체는 한번 생성되면 유효기간 동안 서버의 메모리에 상주한다.
		 * Session은 꼭 필요한 경우에만 생성하는 것이 좋다.
		 */
	}
	
	/*
	 * 사용자에게 Response를 할때 forward 방법과 redirect 방법이 있다
	 * 
	 * forwarding은 service 등 에서 생성한(조회한) 데이터를 
	 * *.jps 파일과 Rendering 하여 사용자에게 HTML 코드로 전송한다
	 * 
	 * service 등에서 생성한 데이터는 
	 * Model 객체에 addAttribute() method를 사용하여 객체를 만들고
	 * 
	 * 
	 * class Spring ___ {
	 * 		main(){
	 * 			HomeController hController = new HomController();
	 * 			Locale locale = new Locale();
	 * 			Model model = new Model();
	 * 			hController.home(locale, model)
	 * 			String url = hController.hom(locale, model)
	 * 
	 * 			if( !url.contains("redirect") ){
	 * 				rendering(url, model);
	 * 			}
	 * 		}
	 * }
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.debug("User Name : {} ",user_name);
		log.debug("User Email : {} ",user_email);
		
		/*
		 * 매개변수로 전달받은 Model class type 변수인 model에 속성을 하나 추가한다.
		 * 속성의 이름은 user이며, 값은 user_name에 담긴 값이다.
		 * 
		 * 
		 */
		
		// user라는 이름으로 user_name에 담긴 변수를 셋팅하여 home으로 전송
		model.addAttribute("user", user_name);
		
		rentService.viewBookAndComp();
		
		return "home";
	}
	
	
	
}
