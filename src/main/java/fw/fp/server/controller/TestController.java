package fw.fp.server.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fw.fp.server.entity.Item;
import fw.fp.server.entity.Question;
import fw.fp.server.entity.QuestionTest;
import fw.fp.server.entity.Test;
import fw.fp.server.repository.QuestionTestRepository;
import fw.fp.server.service.QuestionService;
import fw.fp.server.service.QuestionTestService;
import fw.fp.server.service.TestService;
import fw.fp.server.service.UserService;


@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionTestService questionTestService;
	
	@ModelAttribute("item")
	public Item construct(){
		return new Item();
	}
	
	@RequestMapping("/testDetail")
	public String testDetail(){
		return "testDetail";
	}
	
	@RequestMapping("/front-end")
	public String frontEnd(){
		return "frontEndMainPage";
	}
	
	@RequestMapping("/back-end")
	public String backEnd(){
		return "backEndMainPage";
	}
	
	@RequestMapping("/back-end/{test}")
	public String createTest(@PathVariable String test, Model model, Principal principle){
		String name = principle.getName();
		model.addAttribute("user", userService.findOneWithTests(name));
		return "backEndMainPage";
	}

	@RequestMapping("/remove/{id}")
	public String removetest(@PathVariable int id){
		Test test = testService.findOne(id);
		testService.delete(test);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/template")
	public String template(){
		return "testTemplate";
	}
	
	@RequestMapping("/template/{category}/{difficulty}/{id}")
	public String question(Model model, @PathVariable String category,@PathVariable String difficulty, @PathVariable int id){
		System.out.println("category:" + category + "difficulty:" + difficulty);
		QuestionTest questionTest = questionTestService.findByCategoryAndDifficulty(category,difficulty);
		if(questionTest == null)	System.out.println("@#$@#$@#$#@$@#$");
		Question question = questionService.findByQuestionTestAndId(questionTest, id);
		model.addAttribute(question);
		return "testTemplate";
	}
	
	
	@RequestMapping(value="/template/{category}/{difficulty}/{id}", method=RequestMethod.POST)
	public String questionHandler(@ModelAttribute("item") Item item, @PathVariable String category,@PathVariable String difficulty, @PathVariable int id, Principal principle){
		
		String name = principle.getName();
		Test test = testService.getTest(name, category, difficulty);
		testService.saveItem(test, item);
		return "testTemplate";
	}
	

	
	
	
}
