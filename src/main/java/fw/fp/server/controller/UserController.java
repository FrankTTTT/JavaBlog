package fw.fp.server.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fw.fp.server.entity.Test;
import fw.fp.server.entity.User;
import fw.fp.server.service.QuestionService;
import fw.fp.server.service.TestService;
import fw.fp.server.service.UserService;

@Controller
public class UserController {
	
		@Autowired
		private UserService userService;
		
		@Autowired
		private TestService testService;
		                                                 
		@RequestMapping("/users")
		public String users(Model model){
			model.addAttribute("users", userService.findAll());
			return "users";
		}
			
		@RequestMapping("/users/{id}")
		public String detail(Model model, @PathVariable int id){
			model.addAttribute("user", userService.findOneWithTests(id));
			return "user-detail";
		}
		
		@RequestMapping("/register")
		public String showRegister(){
			return "user-register";
		}
		
		@ModelAttribute("user")
		public User constructUser(){
			return new User();
		}
		
		@ModelAttribute("test")
		public Test construct(){
			return new Test();
		}
		
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public String doRegister(@ModelAttribute("user") User user){
			userService.save(user);
			return "login";
		}
		
		@RequestMapping("/account")
		public String account(Model model, Principal principle){
			String name = principle.getName();
			model.addAttribute("user", userService.findOneWithTests(name));
			return "user-detail";
		}
		
		
		@RequestMapping(value="/account", method=RequestMethod.POST)
		public String doAddtest(@ModelAttribute("test") Test test, Principal principle){
			String name = principle.getName();
			testService.save(test, name);
			String cString = (String) test.getCategory();
			String difficulty = test.getDifficulty();
			String redirectAddr = "/test/template/" + cString + "/" + difficulty + "/1.html";
			return "redirect:" + redirectAddr;
		}
		
		@RequestMapping("/users/remove/{id}")
		public String removeUser(@PathVariable int id){
			userService.delete(id);
			return "redirect:/users.html";
		}
		

		
}
