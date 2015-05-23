package fw.fp.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fw.fp.server.entity.Question;
import fw.fp.server.entity.QuestionTest;
import fw.fp.server.entity.Test;
import fw.fp.server.entity.Item;
import fw.fp.server.entity.Role;
import fw.fp.server.entity.User;
import fw.fp.server.repository.QuestionRepository;
import fw.fp.server.repository.QuestionTestRepository;
import fw.fp.server.repository.TestRepository;
import fw.fp.server.repository.ItemRepository;
import fw.fp.server.repository.RoleRepository;
import fw.fp.server.repository.UserRepository;


@Transactional
@Service
public class InitDbService {
	@Autowired
	private RoleRepository roleRepository; 
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionTestRepository questiontestRepository;
	
	@PostConstruct
	
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleUser.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);				//database storage!
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Test test = new Test();
		test.setCategory("java");
		test.setScore(0);
		test.setName("java test1");
		test.setUser(userAdmin);
		testRepository.save(test);
		
		
		
		QuestionTest questionTest = new QuestionTest();
		questionTest.setCategory("java");
		questionTest.setDifficulty("easy");
		questiontestRepository.save(questionTest);
		
		Question question1 = new Question();
		question1.setCorrectAnswer("4");
		question1.setDescription("Which three form part of correct array declarations?");
		String a = "public int a [ ]";
		String b = "static int [ ] a";
		String c = "public [ ] int a";
		String d = "private int a [3]";
		String e = "private int [3] a [ ]";
		String f = "public final int [ ] a"; 
		List<String> options = new ArrayList<String>();
		options.add(a);
		options.add(b);
		options.add(c);
		options.add(d);
		options.add(e);
		options.add(f);
		question1.setOptions(options);
		question1.setQuestionTest(questionTest);
		questionRepository.save(question1);
		
		Question question2 = new Question();
		question2.setCorrectAnswer("4");
		question2.setDescription("which number");
		question2.setOptions(options);
		question2.setQuestionTest(questionTest);
		questionRepository.save(question2);
		
		
		Item item1 = new Item();
		item1.setUseranswer("Dota2");
		item1.setScore(true);
		item1.setQuestion(question1);
		item1.setTest(test);
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setUseranswer("Dota");
		item2.setQuestion(question2);
		item2.setTest(test);
		itemRepository.save(item2);
	}
	
	
}
