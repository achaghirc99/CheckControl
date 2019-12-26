
package acme.features.sponsor.commercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.commercialbanners.Commercialbanner;
import acme.entities.roles.Sponsor;
import acme.entities.spams.Spamlist;
import acme.framework.entities.Administrator;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorCommercialbannerRepository extends AbstractRepository {

	@Query("select c from Commercialbanner c where c.id=?1") 	//Para Show
	Commercialbanner findOneCommercialbannerById(int id);

	@Query("select c from Commercialbanner c where c.sponsor.id=?1")	//Para List
	Collection<Commercialbanner> findManyByIdCommercialbanners(int id);

	@Query("select s from Sponsor s where s.id=?1") //Para poder obtener la creditCard
	Sponsor findOneSponsorById(int id);

	@Query("select ua from UserAccount ua where ua.id=?1")
	UserAccount findUserccount(int id);

	@Query("select a from Administrator a where a.id=?1")
	Administrator findAdministrator(int id);

	@Query("select c from Commercialbanner c where c.id =?1 and c.sponsor.id=?2")	//Para List
	Collection<Commercialbanner> findCommercialbannersByIdAndSponsor(int id, int sponsorId);

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();
}
