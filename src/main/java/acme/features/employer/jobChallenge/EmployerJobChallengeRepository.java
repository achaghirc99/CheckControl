
package acme.features.employer.jobChallenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobChallengeRepository extends AbstractRepository {

	@Query("select j from Job j where j.id=?1")
	Job getJobById(int id);
}
