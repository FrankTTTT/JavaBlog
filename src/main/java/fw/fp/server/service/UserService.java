package fw.fp.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fw.fp.server.entity.Test;
import fw.fp.server.entity.Item;
import fw.fp.server.entity.Role;
import fw.fp.server.entity.User;
import fw.fp.server.repository.TestRepository;
import fw.fp.server.repository.ItemRepository;
import fw.fp.server.repository.RoleRepository;
import fw.fp.server.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private ItemRepository itemRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithTests(int id) {
		// TODO Auto-generated method stub
		User user = findOne(id);
		List<Test> tests = testRepository.findByUser(user);
		for (Test b : tests) {
			List<Item> items = itemRepository.findByTest(b, new PageRequest(0,10));
			b.setItems(items);
		}
		user.setTests(tests);
		return user;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		user.setEnabled(true);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	public Object findOneWithTests(String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		return findOneWithTests(user.getId());
	}
		
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

}
