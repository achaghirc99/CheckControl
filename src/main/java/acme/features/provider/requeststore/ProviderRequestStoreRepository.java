
package acme.features.provider.requeststore;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import acme.entities.requeststores.Requeststore;
import acme.framework.repositories.AbstractRepository;

public interface ProviderRequestStoreRepository extends AbstractRepository {

	@Query("select r from Requeststore r where r.id = ?1")
	Requeststore findOneRequest(int id);

	@Query("select r from Requeststore r")
	Collection<Requeststore> findManyAll();

	@Query("select r from Requeststore r where r.ticker = ?1")
	Requeststore findOneRequestByTicker(String ticker);

	@Query("select r from Requeststore r where r.deadline >= ?1 and r.reward.amount >= ?2")
	Collection<Requeststore> findRequeststoreByDeadlineAndAmount(Date deadline, Double amount);

}
