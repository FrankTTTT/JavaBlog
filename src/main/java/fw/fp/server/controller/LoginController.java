package fw.fp.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
	@RequestMapping(value= "/login")
	public String login(){
		return "login";
	}
	@RequestMapping(value="/loginError")
	public String loginError(){
		return "loginError";
	}
}


