
package acme.features.authenticated.register;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.register.Register;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRegisterRepository extends AbstractRepository {

	@Query("select a from Register a where a.id = ?1")
	Register findOneById(int id);

	@Query("select r from Register r")
	Collection<Register> findManyAll();

}
