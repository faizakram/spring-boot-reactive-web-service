
package spring.boot.reactive.web.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import spring.boot.reactive.web.model.User;

@Repository
public interface SaUserRepository extends ReactiveCrudRepository<User, String> {

	@Query("{ id: { $exists: true }}")
	Flux<User> retrieveAllQuotesPaged(final Pageable page);
}
