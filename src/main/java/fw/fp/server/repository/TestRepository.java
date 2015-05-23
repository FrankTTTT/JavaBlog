package fw.fp.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fw.fp.server.entity.Test;
import fw.fp.server.entity.User;


public interface TestRepository extends JpaRepository<Test, Integer> {
		List<Test> findByUser(User user);

		Test findByUserAndCategoryAndDifficulty(User user, String category,
				String difficulty);
}
