
package acme.features.employer.duty;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.dutys.Duty;
import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.spams.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobDutyRepository extends AbstractRepository {

	@Query("select d from Duty d where d.descriptor.id=?1")
	Collection<Duty> findManyDutiesByDescriptorId(int parseInt);

	@Query("select d from Duty d where d.id = ?1")
	Duty findOneDutyById(int idDuty);

	@Query("select d from Descriptor d where d.id = ?1")
	Descriptor findOneDescriptorById(int id);

	@Query("select j from Job j where j.descriptor.id = ?1")
	Job finOneJobByDutyId(int id);

	@Query("select j from Job j where j.employer.id = ?1 and j.descriptor.id=?2")
	List<Job> findManyJobsByEmployerId(int idEmployer, int idDescriptor);

	@Query("select s from Spamlist s")
	Spamlist findSpamlist();

}
