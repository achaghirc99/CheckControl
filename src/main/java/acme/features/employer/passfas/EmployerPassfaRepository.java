
package acme.features.employer.passfas;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.passfas.Passfa;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerPassfaRepository extends AbstractRepository {

	@Query("select j from Job j where j.id=?1")
	Job getJobById(int id);

	@Query("select p from Passfa p where p.id =?1")
	Passfa findPassfaById(Integer id);

	@Query("select p from Passfa p where p.job.id = ?1")
	Collection<Passfa> findAllPassfasById(String id);

	@Query("select j from Job j where j.employer.id=?1")
	Collection<Job> getAllJobsById(Integer idPricipal);
}
