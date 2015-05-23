package fw.fp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fw.fp.server.entity.QuestionTest;

public interface QuestionTestRepository extends JpaRepository<QuestionTest, Integer> {

	QuestionTest findByCategoryAndDifficulty(String category, String difficulty);

}
