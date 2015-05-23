package fw.fp.server.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fw.fp.server.entity.Item;
import fw.fp.server.entity.Test;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByTest(Test test, Pageable Pageable);
}
