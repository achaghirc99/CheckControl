
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletin.FriasBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousFriasBulletinRepository extends AbstractRepository {

	@Query("select b from FriasBulletin b")
	Collection<FriasBulletin> findMany();

}
