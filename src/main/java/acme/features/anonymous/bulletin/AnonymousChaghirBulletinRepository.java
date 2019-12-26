
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.ChaghirBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousChaghirBulletinRepository extends AbstractRepository {

	@Query("select s from ChaghirBulletin s")
	Collection<ChaghirBulletin> findMany();
}
