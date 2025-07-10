package org.zerock.controller;


import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;


import lombok.extern.log4j.Log4j2;

@Controller	// servlet-context.xml 에서 <context:component-scan base-package="org.zerock.controller" /> 를 통해 controller 작동
@RequestMapping("/sample/*") // http://192.168.111.104:80/controller/sample/의 모든 루트에 반응한다.
@Log4j2 // resources폴더에 log4j2.xml이 필수
public class SampleController {

	@RequestMapping("") // http://192.168.111.104:80/controller/sample/
	
	public void basic() {
		
		log.info("SampleController.basic() 메서드 실행...........");
		log.info("return이 void 이기 때문에 basic.jsp 파일을 찾습니다.");
		log.info("현재 /WEB-INF/view/basic.jsp가 없으므로 chrome에는 오류가 납니다.");
		//return이 void 임 : 파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다.
		//기본적으로 url에 경로에 대한 jsp를 찾으려고 한다.
		
	} // basic method terminated
	
	
		
		@RequestMapping(value = "/basic", method={RequestMethod.GET,RequestMethod.POST})
		// http://192.168.111.104:80/controller/sample/basic -> RUN GET method, POST method BOTH TYPE
		public void basicGet() {
			log.info("SampleController.basicGet() 메서드 실행...........");
			log.info("GET, POST 둘 다 반응한다.");
		
	} // basicGet method terminated
	
		@GetMapping("/basicOnlyGet")
		public void basicGet2() {
			log.info("SampleController.basicGet2() method run...........");
			log.info("get 방식 반응한다......");
			
		}// basicGet2 method terminated
		
		
		@PostMapping("/basicOnlyPost")
		public void basicPost2() {
			log.info("SampleController.basicPost2() method run............");
			log.info("post method response");
		} // basicPost2 method terminated
		
		
		@GetMapping("/ex01") // http://192.168.111.104:80/controller/sample/ex01?name=kkw&age=33
		public String ex01(SampleDTO dto) { // SampleDTO dto = new SampleDTO();			
			log.info("SampleController.ex01() method run................");
			log.info("responding get method.................");
			log.info("check input dto : "+dto);
			
			
			return "mbcex01"; // WEB-INF/views/ex01.jsp => servlet-context.xml will bring the file.
			
		} // ex01 method terminated
		
		@GetMapping("/ex02") // http://192.168.111.104:80/controller/sample/ex02
		public String ex02(@RequestParam("owner") String name, @RequestParam("age") int age){
			// when front variable, back variable doesn't match (better not to mismatch the variables)
			
			log.info("name: "+name);
			log.info("age: "+age);
			
			return "ex02";
			
		}
		
		@GetMapping("/ex02List")
		// http://192.168.111.104:80/controller/sample/ex02List?ids=111&ids=222&ids=333
		public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
			//Data from List
			
			log.info("Data from List : " + ids);
			log.info("second index of List: " + ids.get(1));
			
			return "ex02List";
		}
		
		@GetMapping("/ex02Bean")
		public String ex02Bean(SampleDTOList list) {
			// parameter which inserted in url path
			//  /ex02Bean?list[0].name=kkw&list[2].age=33
			log.info("list SampleDTOs: "+list);
			
			return "ex02Bean";
		}
		
		@GetMapping("/ex03")
		public String ex03(TodoDTO todo) {
			
			log.info("todo: " + todo);
			
			return "ex03";
		}
		
		@GetMapping("/ex04") // http://192.168.111.104:80/controller/sample/ex04
		public String ex04(SampleDTO dto, @ModelAttribute("page") int page) { //int page는 게시판에 페이징 기법
			//@ModelAttribut("page") 안쓰면 백엔드에는 전달이 되지만, 프론트에는 전달이 안됨
			//스프링에서 기본적으로 제공되는 model 객체를 사용하게 설정을 한다.
			
			log.info("dto: " + dto); //name, age
			log.info("page: " + page);
			
			
			return "/sample/ex04"; //views/sample/ex04.jsp 를 찾는다.
		}
		@GetMapping("/ex05") 
		public void ex05() {
			log.info("SampleControllr.ex05 메서드 발동");
		}
		
		// 리턴이 void인 경우에는 자동으로 [/WEB-INF/views/sample/ex05.jsp 를 찾는다.
		// 초보자 사용 금지!


		@GetMapping("/ex06")
		public @ResponseBody SampleDTO ex06() {
			// @ResponseBody SampleDTO : 응답바디에 객체를 담아 리턴을 한다.
			
			log.info("SampleController.ex06 메서드 실행....");
			
			SampleDTO dto = new SampleDTO();
			dto.setName("kkw");
			dto.setAge(33);
			
			return dto;
		}

		@GetMapping("/ex07")
		public ResponseEntity<String> ex07() {
			// ResponseEntity<String> 응답 헤더 (200 ok, 404, 304)를 만들어 리턴한다.
			log.info("SampleController.ex07 메서드 실행");
			
			String msg = "{\"name\":\"kkw\"}"; // json으로 {name : kkw}
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type","application/json;charset=UTF-8");
			// 헤더에 타입 추가용
			
			return new ResponseEntity<String>(msg, header, HttpStatus.OK);
			// msg에는 json 데이터 / header에는 json타입 / 상태값은 ok -> 200
			
		}

}