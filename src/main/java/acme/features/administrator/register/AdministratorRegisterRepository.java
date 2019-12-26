
package acme.features.administrator.register;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.register.Register;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorRegisterRepository extends AbstractRepository {

	@Query("select a from Register a where a.id=?1")
	Register findOneRegisterById(int id);

	@Query("select a from Register a")
	Collection<Register> findManyRegisters();

}
