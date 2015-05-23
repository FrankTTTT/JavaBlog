package fw.fp.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fw.fp.server.entity.Question;
import fw.fp.server.entity.QuestionTest;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Question findByQuestionTestAndId(QuestionTest questionTest, int id);

	

}
