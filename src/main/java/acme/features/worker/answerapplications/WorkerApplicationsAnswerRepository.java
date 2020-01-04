
package acme.features.worker.answerapplications;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerApplicationsAnswerRepository extends AbstractRepository {

	@Query("select a from Application a where a.id= ?1")
	Application getApplicationById(int parseInt);

}
