
package acme.features.authenticated.jobs;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.status = acme.entities.jobs.JobStatus.PUBLISHED and j.deadline >?1")
	Collection<Job> findAllJobs(Date minDate);

	@Query("select j from Job j where j.id=?1 ")
	Job findOneJobById(int id);
}
