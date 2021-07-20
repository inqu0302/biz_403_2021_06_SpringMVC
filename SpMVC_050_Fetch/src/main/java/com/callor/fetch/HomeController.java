package com.callor.fetch;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.fetch.model.UserDTO;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String json(Model model) {
		return "json";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		return "form";
	}
	
	/*
	 * Web Client 와 JSON데이터 교환하기
	 * Web 에서 JSON데이터를 보내면 Controller에서는 @RequestBody속성을 사용하여 데이터를  받고
	 * Web에 다시 JSON 데이터를 return 하기위해서는 @ResponseBody 속성을 사용하여 데이터를 return 한다
	 */
	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public String json(@RequestBody String user_id, Model model) {
		return user_id;
	}
	
	/*
	 * Controller에서 Web에서 보낸 데이터가 2가지 이상의 변수에 해당하면 
	 * 무조건 VO, DTO를 만들어서 받는다
	 * @RequestBody는 Jackson Bind에 의해서 Web에서 전달된 JSON 데이터를 DTO클래스에 binding한다.
	 * 
	 * spring 4.x에서는 Jackson bind가 기본으로 포함되었으나
	 * 5.x 버전부터는 Jackson bind가 포함되지 않아 pom.xml에서 포함시켜 줘야한다.
	 */
	@ResponseBody
	@RequestMapping(value = "/json/dto", method = RequestMethod.POST)
	public UserDTO json(@RequestBody  UserDTO userDTO, Model model) {
		System.out.print("Web에서 받은 데이터 : ");
		System.out.println(userDTO.toString());
		return userDTO;
	}
	
	@ResponseBody
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public UserDTO form(@RequestBody UserDTO userDTO, Model model) {
		return userDTO;
	}
}
