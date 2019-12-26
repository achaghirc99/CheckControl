
package acme.features.sponsor.noncommercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.noncommercialbanners.Noncommercialbanner;
import acme.entities.roles.Sponsor;
import acme.entities.spams.Spamlist;
import acme.framework.entities.Administrator;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorNonCommercialbannerRepository extends AbstractRepository {

	@Query("select n from Noncommercialbanner n where n.id= ?1") 	//Para Show
	Noncommercialbanner findOneNonCommercialbannerById(int id);

	@Query("select n from Noncommercialbanner n where n.sponsor.id= ?1")	//Para List
	Collection<Noncommercialbanner> findManyByIdNonCommercialbanners(int id);

	@Query("select s from Sponsor s where s.id=?1") //Para poder obtener la creditCard
	Sponsor findOneSponsorById(int id);

	@Query("select ua from UserAccount ua where ua.id=?1")
	UserAccount findUserccount(int id);

	@Query("select a from Administrator a where a.id=?1")
	Administrator findAdministrator(int id);

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();
}
