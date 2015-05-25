package fw.fp.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fw.fp.server.entity.Item;
import fw.fp.server.entity.Question;
import fw.fp.server.entity.Test;
import fw.fp.server.repository.ItemRepository;



@Service
public class ItemService {

	
	@Autowired
	private ItemRepository itemRepository;
	
	public void save(Item item, Test test, Question question) {
		// TODO Auto-generated method stub
		System.out.println("99");
		item.setTest(test);
		item.setQuestion(question);
		System.out.println("101");
		if(item.getUseranswer().equals(question.getCorrectAnswer()))	item.setScore(true);
		System.out.println("101");
		itemRepository.save(item);
		System.out.println("102");
	}
	
}
