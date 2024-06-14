package com.my.spring.web.ch05.ex01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.web.ch05.domain.User;

// REST API를 제공하는 웹서비스를 RESTful하다고 말한다.
@RestController("ch05.ex01") // @Controller-@Component가 있으므로 container에 Ioc된다.
@RequestMapping("ch05/ex01") // 과거의 Controller는 view가 중요했지만, RESTful에
public class UserController {
	@GetMapping("main")
	public ModelAndView main(ModelAndView mv) { // ModelAndView = Model + View, 값을넣을때: addObject(), 값을 보낼view 세팅: setViewName()
		mv.setViewName("ch05/ex01/main"); // 첫번째 화면 view는 전달해줘야할때
		return mv;
	}
	
	//GET방식은 request에 담는 parameter가 queryString으로 넘겨지므로 header에 포함.
	@GetMapping("get") // @GET은 데이터가 안넘겨질 수 있다. view만 넘길수있어, request에 대해 데이터를 넘겨주는걸 parameter라고 한다.
	public User get(User user) { // 이 커맨더 파라미터안에는 @requestParam이 생략된것.
		return user; // RESTful에서 model을 return한다? json으로 변환해서 자동으로 return해줌(key: value)
	}
	
	@PutMapping("put") // CRUD중 Update에 해당하는 것
	public User put(@RequestBody User user) {
		return user;
	}
	
	@PatchMapping("patch") // CRUD중 Update에 해당하는 것, put,patch 둘다 수정이지만 put이 더 넓은 범위의 수정
	public User patch(@RequestBody User user) {
		return user;
	}
	
	@DeleteMapping("delete") // CRUD중 Delete에 해당하는 것
	public User delete(@RequestBody User user) {
		return user;
	}

}
