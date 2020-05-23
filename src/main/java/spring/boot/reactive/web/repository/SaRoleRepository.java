
package spring.boot.reactive.web.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import spring.boot.reactive.web.model.Role;

@Repository
public interface SaRoleRepository extends ReactiveCrudRepository<Role, String> {

}
