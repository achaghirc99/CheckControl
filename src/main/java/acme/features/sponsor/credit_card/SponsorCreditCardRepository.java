
package acme.features.sponsor.credit_card;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.creditCard.CreditCard;
import acme.entities.roles.Sponsor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorCreditCardRepository extends AbstractRepository {

	@Query("select s from Sponsor s where s.id=?1")
	Sponsor findSponsor(int id);

	@Query("select cc from CreditCard cc where cc.sponsor.id=?1")
	CreditCard findCreditCardBySponsorId(int id);
}
