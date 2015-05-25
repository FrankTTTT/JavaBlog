package fw.fp.server.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fw.fp.server.entity.Item;
import fw.fp.server.entity.Question;
import fw.fp.server.entity.QuestionTest;
import fw.fp.server.entity.Test;
import fw.fp.server.entity.User;
import fw.fp.server.repository.UserRepository;
import fw.fp.server.service.ItemService;
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
	
	@Autowired 
	private ItemService itemService;
	
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
		QuestionTest questionTest = questionTestService.findByCategoryAndDifficulty(category,difficulty);
		Question question = questionService.findByQuestionTestAndId(questionTest, id);
		model.addAttribute(question);
		model.addAttribute(questionTest);
		return "testTemplate";
	}
	
	
	@RequestMapping(value="/template/{category}/{difficulty}/{id}", method=RequestMethod.POST)
	public String questionHandler(@ModelAttribute("item") Item item, @PathVariable String category,@PathVariable String difficulty, @PathVariable int id, Principal principle){
		String name = principle.getName();
		User user = userService.findByName(name);
		Test test = testService.getTest(user, category, difficulty);
		QuestionTest qt = questionTestService.findByCategoryAndDifficulty(category, difficulty);
		Question question = questionService.findByQuestionTestAndId(qt, id);
		itemService.save(item, test, question);
		String redirect = questionTestService.getUrl(category, difficulty, id);
		System.out.println(redirect);
		return "redirect:" + redirect;
	}
	
	@RequestMapping("/template/{category}/{difficulty}/success")
	public String successHandle(Model model, @PathVariable String category, @PathVariable String difficulty, Principal principal){
		String name = principal.getName();
		User user = userService.findByName(name);
		Test test = testService.findByUserAndCategoryAndDifficulty(user, category, difficulty);
		model.addAttribute(test);
		return "testSuccess";
	}
	

	
	
	
}
