
package acme.features.authenticated.requestauditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requestauditors.Requestauditor;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestAuditorRepository extends AbstractRepository {

	@Query("select ua from Authenticated ua where ua.id = ?1")
	Authenticated findOneAuthenticatedById(int id);

	@Query(" select mt from Requestauditor mt where mt.user.id = ?1")
	Collection<Requestauditor> findAllRequestAuditorById(int id);

	@Query("select a from Authenticated a where a.id=?1")
	Authenticated findAuthenticated(int id);

	@Query("select r from Requestauditor r where r.id=?1")
	Collection<Requestauditor> findRequestAuditorById(int id);

}
