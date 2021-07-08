package com.callor.gallery.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
	
	@Qualifier("fileServiceV2")
	protected final FileService fileService;
	
	/*
	 * 필요에따라서 매핑주소를 상세히 작성가능
	 * 매소드 이름은 큰 상관없음
	 * 아무렇게나 적어도 문제 없음
	 * a tag를 클릭했을때 : <a href="${rootPath}/gallery/detail{id}> 
	 * 또는 주소창에 직접 입력시 : http://localhost:8080/gallery/detail/id값
	 * location.href=${rootPath}/gallery/detail/{id} 로 JS에서 실행했을때
	 */
//	@RequestMapping(value = "/gallery/detail/{id}", method=RequestMethod.GET)
//	public String dumy() {
//		return "home";
//	}
	
	/*
	 * method가 POST설정이 되어있기때문에 매소드명이같아도 문맥상 다른매소드임
	 * <form action="${rootPath}/gallery/detial" method="POST">
	 * 		<input name="str">
	 * 		<button type="submit">전송</button>
	 * </form>
	 * 
	 * JSP, html에서 위 코드를 만들고 입력화면을 보여준 후 input box에 어떤 문자열을 입력후
	 * 전송 button을 클릭하면 이 메소드가 request를 받고 input box에 입력한 문자열을 str변수에 담긴다
	 */
//	@RequestMapping(value = "/gallery/detail/{id}", method=RequestMethod.POST)
//	public String dumy(String str) {
//		return "home";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/gallery";
	}

	@RequestMapping(value="/",method=RequestMethod.POST)
	public String home(
			MultipartHttpServletRequest m_file,Model model) throws Exception {
		
//		List<MultipartFile> files = m_file.getFiles("m_file");
//		String fileName = fileService.fileUp(files.get(0));
//		model.addAttribute("file",fileName);
		
		List<String> fileNames = fileService.filesUp(m_file);
		model.addAttribute("FILES", fileNames);
		return "home";
	
	}
	
	
	/*
	 * MultipartHttpServletRequest
	 * 이 클래스는 @RequestParam을 붙이면 안됨
	 * 이 클래스에 @RequestParam을 붙이면 400오류가 난다.
	 */
	@RequestMapping(value = "/sub", method = RequestMethod.POST)
	public String home(
			@RequestParam("one_file") MultipartFile one_file,
			MultipartHttpServletRequest m_file) {
		
		log.debug("파일사이즈  {}", 
				m_file.getFile("m_file").getSize());
		
		/*
		 *  다수의 파일이 업로되면
		 *  파일들의 정보가 m_file 객체에 담기게 된다
		 *  
		 *  m_file 객체에서 getFiles() method를 사용하여
		 *  파일들 list를 추출한다
		 *  List<MulipartFile> type의 객체에 담는다
		 *  
		 *  이때 getFiles() 에는 form에서 설정된 
		 *  input tag의 name 값을 지정해준다
		 *  또한 input tag에는 multiple="multiple" 이 설정되어
		 *  있어야 한다.
		 *  
		 */
		List<MultipartFile> files = m_file.getFiles("m_file");
		for(MultipartFile file : files ) {
			log.debug("파일들 {}", file.getOriginalFilename());
		}
		return "home";
	}
}