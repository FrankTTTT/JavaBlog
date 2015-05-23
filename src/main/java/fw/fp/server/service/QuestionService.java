package fw.fp.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fw.fp.server.entity.Question;
import fw.fp.server.entity.QuestionTest;
import fw.fp.server.repository.QuestionRepository;
import fw.fp.server.repository.QuestionTestRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	public Question findByQuestionTestAndId(QuestionTest questionTest, int id) {
		return questionRepository.findByQuestionTestAndId(questionTest, id);
	}
	
	
	
}
