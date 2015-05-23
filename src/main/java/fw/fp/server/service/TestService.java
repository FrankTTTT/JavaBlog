package fw.fp.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fw.fp.server.entity.Item;
import fw.fp.server.entity.Test;
import fw.fp.server.entity.User;
import fw.fp.server.repository.TestRepository;
import fw.fp.server.repository.UserRepository;


@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(Test test, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		test.setUser(user);
		testRepository.save(test);
	}
	
 
	public void delete(int id) {
		// TODO Auto-generated method stub
		testRepository.delete(id);
	}

	public Test findOne(int id) {
		// TODO Auto-generated method stub
		return testRepository.findOne(id);
	}
	
	@PreAuthorize("#test.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("test") Test test) {
		// TODO Auto-generated method stub
		testRepository.delete(test);
	}


	public void saveItem(Test test, Item item) {
		// TODO Auto-generated method stub
		
	}


	public Test getTest(String name, String category, String difficulty) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		return testRepository.findByUserAndCategoryAndDifficulty(user, category, difficulty);
	}
	
}
