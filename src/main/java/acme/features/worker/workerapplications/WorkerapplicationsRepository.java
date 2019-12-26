
package acme.features.worker.workerapplications;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.entities.spams.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerapplicationsRepository extends AbstractRepository {

	@Query("select w from Application w where w.id=?1")
	Application findOneWorkerapplicationById(int id);

	@Query("select w from Application w where w.worker.id= ?1")
	Collection<Application> findManyWorkerapplications(int id);

	@Query("select w from Worker w where w.id=?1")
	Worker findWorker(int id);

	@Query("select j from Job j where j.id=?1")
	Job findJob(int id);

	@Query("select j from Application j where j.job.id=?1")
	Collection<Application> findApplicationByJobId(int id);

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();

}
