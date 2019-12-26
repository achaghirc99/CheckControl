
package acme.features.auditor.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.Auditrecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordsRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id=?1")
	Auditrecord findOneAuditRecordById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1 and a.auditor.id=?2")
	Collection<Auditrecord> findManyByJobId(int id, int idPrincipal);

	@Query("select a from Auditor a where a.id=?1")
	Auditor findOneAuditorById(int id);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

}
