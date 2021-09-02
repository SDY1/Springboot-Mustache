package com.cos.viewapp.wep;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// RestController(데이터를 리턴한다)
// Controller(파일을 리턴한다)

// 서버실행시 열림
@Controller
public class FrontController {
	
	// http://localhost:8080/home
	// 디스패쳐서블릿 /home
	// IoC 컨테이너에 @RestController, @Controller로 생성된 객체만 찾음
	// 메서드 호출
	// 여기서는 전역변수를 쓰면 충돌나기 때문에 지양
	
	// 요청시 열림
	@GetMapping("/home")
	// 톰켓에서 들고있는 것을 DI
	public String home(Model model) { // request == model
		// ViewResolver 클래스
		// src/main/resources/templates(prefix)
		// .mustache(suffix)
		String name = "SDY";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목2"));
		
		model.addAttribute("boards", boards);
		
		return "home"; // RequestDispatcher가 자동 작동
	}
}
