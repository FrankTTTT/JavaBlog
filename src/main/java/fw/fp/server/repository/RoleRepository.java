package fw.fp.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fw.fp.server.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
