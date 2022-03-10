package Pack01;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller		// 이 클래스가 컨트롤러임을 명시
public class Tiger {
	
	@RequestMapping("/t1")	//함수 매핑
	String func01() {
		System.out.println("호랑이1");
		
		return "TigerView";	//여기서 리턴되는 String은 무조건 JSP이름으로 보고 Tiger.jsp를 찾는다.
	}
	
	@RequestMapping("/t2")	//함수 매핑
	String func02() {
		System.out.println("호랑이2");
		
		return "TigerView";	//여기서 리턴되는 String은 무조건 JSP이름으로 보고 Tiger.jsp를 찾는다.
	}
	
	// Spring을 이용한 인수 받는 방법
	@RequestMapping("/t3")	//함수 매핑
	String func03(
			@RequestParam(value="name") String name) {
		System.out.println("f3 call");
		System.out.println(name);
		
		return "TigerView";
	}
	
	@RequestMapping("/t4")	//함수 매핑
	String func04(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") String age) {
		System.out.println("f4 call");
		System.out.println(name);
		System.out.println(age);
		
		return "TigerView";
	}
	
	// 서블릿 객체를 사용하여 인수를 받는 방법
	@RequestMapping("/t5")	//함수 매핑
	String func05(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("f5 call");
		System.out.println(name);
		System.out.println(age);
		
		return "TigerView";
	}
	
	//model을 활용한 데이터 전달
	@RequestMapping("/t6")	//함수 매핑
	String func06(Model model) {
		System.out.println("f6 call");
		model.addAttribute("name", "독수리");
		model.addAttribute("age", 200);
		return "TigerView";
	}
	
	//Spring과 model을 활용한 데이터 전달
	@RequestMapping("/t7")	//함수 매핑
	String func07(
			Model model,
			@RequestParam(value="name") String name,
			@RequestParam(value="age") int age) {
		System.out.println("f7 call");
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "TigerView";
	}
	
	//ModelAndView 사용법
	@RequestMapping("/t8")	//함수 매핑
	ModelAndView func08() {
		System.out.println("f8 call");
		String s = "TigerView";
		
		ModelAndView mv = new ModelAndView(s);
		mv.addObject("name", "앵무새");
		mv.addObject("age", 25);
		
		return mv;
	}
	
	// form 데이터 전달
	@RequestMapping("/t10")	//함수 매핑
	String func10(Person person) {
		// 속성 10개를 보냈다고 했을때
		// 객체로 10개 한번에 받으려고 한다.
		// DTO(커맨드 객체) ->>
		// VO >> Entity
		
		System.out.println("f10 call");
		System.out.println(person.getId());
		System.out.println(person.getPwd());
		
		return "TigerView";
	}
	
	// 타입별 데이터 전달 
	@RequestMapping("/t11")
	String func11(Model model) {
		// 1. 정수
		int num = 10;
		model.addAttribute("num", num);
		
		// 2. String
		String str = "문자열";
		model.addAttribute("str", str);
		
		// 3. Array
		int[] arr = { 10, 20, 30};
		model.addAttribute("arr", arr);
		
		// 4. 객체 전송
		Person person = new Person();
		person.setId("소나무");
		person.setPwd(1234);
		model.addAttribute("person", person);
		
		// 5. Collection 전송(Integer)
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(40);
		list.add(50);
		list.add(60);
		model.addAttribute("list", list);
		
		// 6. Collection 전송(String)
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("독수리0");
		list2.add("독수리1");
		list2.add("독수리2");
		model.addAttribute("list2", list2);
		
		// 7. Collection 전송(객체)
		LinkedList<Person> list3 = new LinkedList<Person>();
		list3.add(new Person("독수리3", 10));
		list3.add(new Person("독수리4", 20));
		list3.add(new Person("독수리5", 30));
		model.addAttribute("list3", list3);
		
		return "LionView";
	}
	
}
