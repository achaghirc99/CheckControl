
package acme.features.employer.application;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobApplicationsRepository extends AbstractRepository {

	@Query("select j from Job j where j.employer.id = ?1")
	Collection<Job> findManyJobsByIdEmployer(int idEmployer);

	@Query("select a from Application a where a.job.employer.id = ?1")
	Collection<Application> findManyApplicationsByEmployerId(int idEmployer);

	@Query("select a from Application a where a.id = ?1")
	Application findOneWorkerapplicationById(int id);

	@Query("select a.referenceNumber, count(a) from Application a where a.job.employer.id = ?1 group by a.referenceNumber")
	//	Collection<Application> findApplicationGroupedByReference(int EmployerId);
	List<String[]> findApplicationGroupedByReference(int EmployerId);

	@Query("select a, count(a) from Application a where a.job.employer.id = ?1 group by a.job")
	Map<Application, Integer> findApplicationGroupedByStatus(int employerId);
}
