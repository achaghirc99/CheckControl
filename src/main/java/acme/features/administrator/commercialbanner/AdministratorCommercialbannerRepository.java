
package acme.features.administrator.commercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.commercialbanners.Commercialbanner;
import acme.entities.spams.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCommercialbannerRepository extends AbstractRepository {

	@Query("select s from Commercialbanner s where s.id=?1")
	Commercialbanner findOneCommercialbannerById(int id);

	@Query("select s from Commercialbanner s")
	Collection<Commercialbanner> findAllCommercialbanners();

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();
}
