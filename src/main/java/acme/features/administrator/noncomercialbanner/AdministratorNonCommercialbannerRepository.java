
package acme.features.administrator.noncomercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.spams.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNonCommercialbannerRepository extends AbstractRepository {

	@Query("select s from Noncommercialbanner s where s.id = ?1")
	Noncommercialbanner findOneNonCommercialbannerById(int id);

	@Query("select s from Noncommercialbanner s")
	Collection<Noncommercialbanner> findAllNonCommercialbanners();

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();
}
