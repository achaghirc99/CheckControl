
package acme.features.administrator.requestauditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requestauditors.Requestauditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorRequestAuditorRepository extends AbstractRepository {

	@Query("select r from Requestauditor r")
	Collection<Requestauditor> findAllRequestAuditor();

	@Query("select r from Requestauditor r where r.id = ?1")
	Requestauditor findOneById(int id);

	//	@Query("select r from Requestauditor r where r.user.id = ?1")
	//	Requestauditor findOneByUserId(int id);

}
