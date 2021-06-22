package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.serivce.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/author")
public class AuthorController {
	
	protected final AuthorService auService;
	
	public AuthorController(AuthorService auService) {
		this.auService = auService;
	}
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO)hSession.getAttribute("USERVO");
		if(userVO == null) {
			model.addAttribute("MSG", "LOGIN");
			return "redirect:/member/login";
		}
		
		List<AuthorVO> auList = auService.selectAll();
		
		/*
		 * Attribute 를 지정할때 자주하는 실수
		 * Attribute 의 이름은 문자열 형태이기 때문에 어떠한 기호를 사용해도 무방하다
		 * 하지만 jsp 에서 랜더링할때는 문자열이 변수로 취급이된다
		 * 변수로 취급이되면 java의 일반적인 코딩규칙이 적용된다는 뜻이다
		 * 
		 *  작성할때는 문자열이지만, 변수선언 규칙에 맞도록 이름을 작성해야 한다
		 *  AUTH-LIST 와 같이 선언했을때는 변수가 아닌 연산식으로 인식을 하게되어 오류가 발생한다
		 */
		model.addAttribute("AUTHOR", auList);
		log.debug("저자정보 : {}",auList.toString());
		
		return "author/list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	/*
	 * cp_title 을 Req로 받아 변수에 셋팅을하는 annotation
	 * Req 를 할때 cp_title 변수를 보내지 않으면 400 httpStatus오류가 발생한다
	 * 400 오류는 서버 App 디버깅 과정에서 상당히 관리가 어려운 오류가 된다.
	 * 
	 * 단순한 변수 (VO, DTO, MAP 형식이 아닌 단일변수)를 사용하는 경우는
	 * @requestParam의 required 옵션을 false로 선언하고 default값을 임의로 설정해드면
	 * 코드 내에서 핸들링 할수 있다.
	 */
	public String search(@RequestParam(name = "au_name", required = false, defaultValue = "")
							String au_name, Model model) {
		
		if(au_name == null || au_name.equals("")) {
			
			List<AuthorVO> authorList = auService.selectAll();
			model.addAttribute("AUTHOR", authorList);
			
		} else {
			
			List<AuthorVO> authorList = auService.findByNameAndTel(au_name);
			model.addAttribute("AUTHOR", authorList);
			
		}
		
		
		return "author/search";
	}

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		
		return "author/input";
	}
}
