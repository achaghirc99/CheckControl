
package acme.features.anonymous.bulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletin.RenesesBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousRenesesBulletinRepository extends AbstractRepository {

	@Query("select s from RenesesBulletin s")
	Collection<RenesesBulletin> findMany();

}
