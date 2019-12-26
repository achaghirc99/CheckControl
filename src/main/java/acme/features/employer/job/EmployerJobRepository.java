
package acme.features.employer.job;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.spams.Spamlist;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id=?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.employer.id=?1")
	Collection<Job> findManyByEmployerId(int idEmployer);

	@Query("select e from Employer e where e.id=?1")
	Employer findEmployerById(int idEmployer);

	@Query("select a from UserAccount a where a.id = ?1")
	UserAccount findUserAccountById(int id);

	@Query("select s.spamWord from Spam s")
	List<String> getAllSpamWords();

	@Query("select j.application from Job j where j.id = ?1")
	Collection<Application> finApplicationsByJobId(int id);

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();
}
