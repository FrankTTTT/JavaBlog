package fw.fp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fw.fp.server.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}


//Jpa Repository will do the automatic thing here!!!!!