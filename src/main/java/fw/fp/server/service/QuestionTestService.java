package fw.fp.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fw.fp.server.entity.QuestionTest;
import fw.fp.server.repository.QuestionTestRepository;

@Service
public class QuestionTestService {
	@Autowired
	private QuestionTestRepository questionTestRepository;

	public QuestionTest findByCategoryAndDifficulty(String category, String difficulty) {
		return questionTestRepository.findByCategoryAndDifficulty(category, difficulty);
	}

	
	public String getUrl(String category, String difficulty, int id) {
		QuestionTest qt = questionTestRepository.findByCategoryAndDifficulty(category, difficulty);
		if(id == qt.getSize())	return "/test/template/" + category + "/" + difficulty + "/success.html";
		int temp = id + 1;
		return "/test/template/" + category + "/" + difficulty + "/" + temp + ".html";
	}
}
