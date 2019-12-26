
package acme.features.authenticated.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.dutys.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobDutyRepository extends AbstractRepository {

	@Query("select d from Duty d where d.descriptor.id=?1")
	Collection<Duty> findManyDutiesByDescriptorId(int parseInt);

	@Query("select d from Duty d where d.id = ?1")
	Duty findOneDutyById(int idDuty);

}
