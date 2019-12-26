
package acme.features.anonymous.maciasportillobulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.maciasportillobulletins.maciasportillobulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousmaciasportillobulletinRepository extends AbstractRepository {

	@Query("select s from maciasportillobulletin s")
	Collection<maciasportillobulletin> findMany();

}
