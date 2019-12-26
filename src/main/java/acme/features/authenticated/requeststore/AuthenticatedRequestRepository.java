
package acme.features.authenticated.requeststore;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requeststores.Requeststore;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestRepository extends AbstractRepository {

	@Query("select r from Requeststore r where r.id = ?1")
	Requeststore findOneById(int id);

	@Query("select r from Requeststore r")
	Collection<Requeststore> findManyAll();

}
