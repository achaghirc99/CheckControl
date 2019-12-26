
package acme.features.consumer.offers;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ConsumerOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneOffer(int id);

	@Query("select o from Offer o")
	Collection<Offer> findManyAllOffers();

	@Query("select o from Offer o where o.ticker = ?1")
	Offer findOfferByTicker(String ticker);

	@Query("select o from Offer o where o.deadline = ?1")
	Offer findOfferByDeadline(Date deadline);

	@Query("Select o from Offer o where o.deadline >= ?1 and o.reward.amount >= ?2")
	Offer findOfferByDaSalary(Date deadline, Double salary);

}
